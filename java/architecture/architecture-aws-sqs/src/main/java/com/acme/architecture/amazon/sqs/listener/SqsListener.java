package com.acme.architecture.amazon.sqs.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SqsListener implements MessageListener {

	private static final Logger LOG = LoggerFactory.getLogger(SqsListener.class);

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;

        try {
        	LOG.info("Received message "+ textMessage.getText());
        } catch (JMSException e) {
        	LOG.error("Error processing message ",e);
        }
	}

}
