package com.acme.sqs.connector.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import com.acme.sqs.common.entity.CustomEvent;

@Component
public class SqsSubscriber {
	
	private static final Logger LOG = LoggerFactory.getLogger(SqsSubscriber.class);

	@SqsListener("${sqs.queue}")
    public void subscribeToSQSDirectly(final CustomEvent msg) {
		LOG.error("Received message: " + msg);
    }

	@SqsListener("${sqs.queue.sns.fanout}")
    public void subscribeToSNSFanout(@NotificationMessage final CustomEvent msg) {
		LOG.error("Received message from SNS topic: " + msg);
    }
}
