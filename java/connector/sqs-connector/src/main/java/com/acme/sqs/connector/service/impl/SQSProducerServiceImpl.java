package com.acme.sqs.connector.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.acme.sqs.common.entity.CustomEvent;
import com.acme.sqs.connector.service.ProducerService;
import com.amazon.sqs.javamessaging.SQSMessagingClientConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SQSProducerServiceImpl implements ProducerService {

	private static final Logger LOG = LoggerFactory.getLogger(SQSProducerServiceImpl.class);
	
	@Resource
    protected JmsTemplate jmsTemplate;
	
	@Resource
    ObjectMapper objectMapper;
	
	@Value("${aws.sqs.queue.a}")
    String queueA;

    @Value("${aws.sqs.queue.b}")
    String queueB;

	@Override
	public <T extends Serializable> void send(String queue, T value) {
		jmsTemplate.send(queue, new MessageCreator(){

            public javax.jms.Message createMessage(Session session) throws JMSException {
                try {
                    javax.jms.Message createMessage = session.createTextMessage(objectMapper.writeValueAsString(value));
                    createMessage.setStringProperty(SQSMessagingClientConstants.JMSX_GROUP_ID, "messageGroup1");
                    createMessage.setStringProperty(SQSMessagingClientConstants.JMS_SQS_DEDUPLICATION_ID, "1" + System.currentTimeMillis());
                    createMessage.setStringProperty("documentType", value.getClass().getName());
                    return createMessage;
                } catch (Exception | Error e) {
                    LOG.error("Fail to send message {}", value);
                    throw new RuntimeException(e);
                }
            }
        });
	}
	
	public void sendToQueueA(CustomEvent event) {
		LOG.info("Sending {} to queue {}", event, queueA);
        send(queueA, event);
    }

    public void sendToQueueB(CustomEvent event) {
    	LOG.info("Sending {} to queue {}", event, queueB);
        send(queueB, event);
    }


}
