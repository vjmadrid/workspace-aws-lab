package com.acme.sqs.connector.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

import com.acme.sqs.common.entity.CustomEvent;

@Component
public class SqsPublisher {

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	@Value("${sqs.queue}")
	private String queue;

	public void send(CustomEvent msg) {
		queueMessagingTemplate.convertAndSend(queue, msg);
	}
}
