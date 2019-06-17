package com.acme.architecture.amazon.sqs.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.architecture.amazon.sqs.resolver.SqsDestinationResolver;
import com.acme.architecture.amazon.sqs.service.SQSService;
import com.acme.architecture.amazon.sqs.validator.SQSValidator;
import com.acme.architecture.common.validator.GenericValidator;
import com.amazon.sqs.javamessaging.AmazonSQSMessagingClientWrapper;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

public class SQSServiceImpl implements SQSService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SQSServiceImpl.class);
	
	@Resource
	private AmazonSQS sqs;
	
	@Resource
	SQSConnectionFactory sqsConnectionFactory;
	
	@Resource
	SqsDestinationResolver sqsDestinationResolver;
	
	public String createQueue(final String queueName){
		String result = null;
		if (GenericValidator.INSTANCE.isValid(queueName)){
			final CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
			result = sqs.createQueue(createQueueRequest).getQueueUrl();
			LOG.info("Creating a new SQS queue called {} ", queueName);
		}
		return result;
    }
	
	public String createQueueWithAttributes(final String queueName, final Map<String, String> queueAttributes){
		String result = null;
		if (GenericValidator.INSTANCE.isValid(queueName) && SQSValidator.INSTANCE.isValid(queueAttributes)){
			final CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
			result = sqs.createQueue(createQueueRequest).getQueueUrl();
			LOG.info("Creating a new SQS queue with attributes called {} ", queueName);
		}
		return result;
    }
	
	public String getQueueUrl(final String queueName){
		String result = null;
		if (GenericValidator.INSTANCE.isValid(queueName)){
			final GetQueueUrlRequest getQueueUrlRequest = new GetQueueUrlRequest(queueName);
			result = sqs.getQueueUrl(getQueueUrlRequest).getQueueUrl();
			LOG.info("Get the SQS queue URL called {} ", queueName);
		}
		return result;
    }
	
	public ListQueuesResult listQueues(){
		ListQueuesResult result = null;
		result = sqs.listQueues();
		LOG.info("Get the SQS queues ");
		return result;
    }
	
	public String deleteQueue(final String queueName){
		String result = null;
		final String queueUrl = getQueueUrl(queueName);
		if (GenericValidator.INSTANCE.isValid(queueUrl)){
			sqs.deleteQueue(new DeleteQueueRequest(queueUrl));
			result = queueName; 
			LOG.info("Deleting SQS queue called {} ", queueName);
		}
		return result;
    }
	
	public String sendMessageToQueue(final String queueName, final String message){
		String result = null;
		final String queueUrl = getQueueUrl(queueName);
		if (GenericValidator.INSTANCE.isValid(queueUrl) && GenericValidator.INSTANCE.isValid(message)){
			final SendMessageResult messageResult =  sqs.sendMessage(new SendMessageRequest(queueUrl, message));
			result = messageResult.toString();
			LOG.info("Sending message '{}' called {} ", message, queueName);
		}
		return result;
    }

	public List<Message> getMessagesFromQueue(final String queueName){
		List<Message>  result = null;
		final String queueUrl = getQueueUrl(queueName);
		if (GenericValidator.INSTANCE.isValid(queueUrl)){
			final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
			result = sqs.receiveMessage(receiveMessageRequest).getMessages();
			LOG.info("Get all messages by the SQS queue called {} ", queueName);
		}
		return result;
    }
	
	public void detailMessage(final Message message) {
		if (message!=null ) {
			LOG.info("MessageId: {}",message.getMessageId());
			LOG.info("ReceiptHandle: {}",message.getReceiptHandle());
			LOG.info("MD5OfBody: {}",message.getMD5OfBody());
			LOG.info("Body: {}",message.getBody());
            for (Entry<String, String> entry : message.getAttributes().entrySet()) {
            	LOG.info("Attribute");
            	LOG.info("\tName: {}" + entry.getKey());
            	LOG.info("\tValue: {}" + entry.getValue());
            }
		}
	}
	
	public String deleteMessageFromQueue(String queueName, String message){
		String result = null;
		final String queueUrl = getQueueUrl(queueName);
		if (GenericValidator.INSTANCE.isValid(queueUrl) && GenericValidator.INSTANCE.isValid(message)){
			final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
            List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
			String messageReceiptHandle = messages.get(0).getReceiptHandle();
			sqs.deleteMessage(new DeleteMessageRequest(queueUrl, messageReceiptHandle));
			LOG.info("Deleting a message {} ", queueName);
		}
		return result;
	}
	
	public Queue initQueue(final String queueName) {
		Queue result = null;
//		//String newQueueName = sqsDestinationResolver(queueName); 
//		if (GenericValidator.INSTANCE.isValid(queueName)){
//			SQSConnection connection;
//			
//			try {
//				connection = sqsConnectionFactory.createConnection();
//				AmazonSQSMessagingClientWrapper client = sqsConnectionFactory.
//				
//				if (!client.queueExists(queueName)) {
//					client.createQueue(queueName);
//				}
//				
//				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//	            return session.createQueue(queueName);
//				
//			} catch (JMSException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            
//			LOG.info("Get the SQS queue called {} ", queueName);
//		}
		return result;
	}

}
