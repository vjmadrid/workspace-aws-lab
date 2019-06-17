package com.acme.architecture.amazon.sqs.config.aws;

import static org.junit.Assert.assertNotNull;

import javax.jms.MessageConsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.architecture.common.constant.SpringConfigConstant;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.services.sqs.AmazonSQSAsync;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AwsConfig.class,SqsConfig.class})
@ActiveProfiles(profiles={SpringConfigConstant.PROFILE_DEFAULT})
public class SqsConfigTest {
	
	@Autowired
	private AmazonSQSAsync amazonSQSAsyncClient;
	
	@Autowired
	private SQSConnectionFactory sqsConnectionFactory;
	
	@Autowired
	private SQSConnection sqsConnection;
	
	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;
	
	@Autowired
	private MessageConsumer sqsMessageConsumer;
	
	@Test
	public void shouldBeInjected() {
		assertNotNull(amazonSQSAsyncClient);
		assertNotNull(sqsConnectionFactory);
		assertNotNull(sqsConnection);
		assertNotNull(queueMessagingTemplate);
		assertNotNull(sqsMessageConsumer);
	}
}
