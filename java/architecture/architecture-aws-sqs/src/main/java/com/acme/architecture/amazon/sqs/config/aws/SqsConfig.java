package com.acme.architecture.amazon.sqs.config.aws;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazon.sqs.javamessaging.SQSSession;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
public class SqsConfig {

	private static final Logger LOG = LoggerFactory.getLogger(SqsConfig.class);

	@Value("${aws.credentials.provider}")
	private String credentialsProvider;

	 @Value("${aws.sqs.queue.a}")
	 private String queueName;

	@PostConstruct
	public void init() {
		LOG.debug("[CONFIGURATION] Configuring SQS ...");
	}

	@Bean
    public AmazonSQSAsync amazonSQSAsyncClient() {
		LOG.debug("[CONFIGURATION] Configuring amazonSQSAsyncClient ...");
        return AmazonSQSAsyncClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider(credentialsProvider))
                .withRegion(Regions.AP_SOUTHEAST_2)
                .build();
    }

    @Bean
    public SQSConnectionFactory sqsConnectionFactory() throws JMSException {
    	LOG.debug("[CONFIGURATION] Configuring sqsConnectionFactory ...");
        return new SQSConnectionFactory(
                new ProviderConfiguration(),
                AmazonSQSClientBuilder.standard()
                        .withRegion(Regions.AP_SOUTHEAST_2)
                        .withCredentials(new ProfileCredentialsProvider(credentialsProvider))
        );
               
    }
    
	@Bean
	public SQSConnection sqsConnection(final AWSCredentialsProvider awsCredentialsProvider,
			final ClientConfiguration awsClientConfig, final Region awsRegion) throws JMSException {
		LOG.debug("[CONFIGURATION] Configuring sqsConnection ...");
		SQSConnectionFactory connectionFactory = SQSConnectionFactory.builder().withRegion(awsRegion) 
				.withAWSCredentialsProvider(awsCredentialsProvider).withClientConfiguration(awsClientConfig).build();

		return connectionFactory.createConnection();
	}
	
	@Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSqs) {
        return new QueueMessagingTemplate(amazonSqs);
    }
	
	@Bean
    public MessageConsumer sqsMessageConsumer(final SQSConnection connection) throws JMSException {

        /*
         * Create the session and use UNORDERED_ACKNOWLEDGE mode. Acknowledging
         * messages deletes them from the queue. Each message must be individually
         * acknowledged
         */
        Session session = connection.createSession(false, SQSSession.UNORDERED_ACKNOWLEDGE);

        return session.createConsumer(session.createQueue(queueName));
    }
	
}
