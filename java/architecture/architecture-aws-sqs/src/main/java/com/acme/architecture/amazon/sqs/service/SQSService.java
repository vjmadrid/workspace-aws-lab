package com.acme.architecture.amazon.sqs.service;

import java.util.List;
import java.util.Map;

import javax.jms.Queue;

import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;

public interface SQSService {
	
	String createQueue(final String queueName);
	String createQueueWithAttributes(final String queueName, final Map<String, String> queueAttributes);
	String getQueueUrl(final String queueName);
	ListQueuesResult listQueues();
	String deleteQueue(final String queueName);
	List<Message> getMessagesFromQueue(final String queueName);
	void detailMessage(final Message message);
	Queue initQueue(final String queueName);
}
