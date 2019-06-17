package com.acme.sqs.connector.service.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.acme.sqs.common.entity.CustomEvent;
import com.acme.sqs.connector.service.ConsumerService;

@Service
public class SQSConsumerServiceImpl implements ConsumerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SQSConsumerServiceImpl.class);

	@Override
	public <T extends Serializable> void process(T value) {
		LOG.info("Processing {} ", value);
	}
	
	@JmsListener(destination = "${aws.queue.a}")
	public void processQueueA(CustomEvent event) {
		LOG.info("Processing {}  in queue a", event);
		process(event);
	}
	
	@JmsListener(destination = "${aws.queue.b}")
	public void processQueueB(CustomEvent event) {
		LOG.info("Processing {}  in queue b", event);
		process(event);
	}

}
