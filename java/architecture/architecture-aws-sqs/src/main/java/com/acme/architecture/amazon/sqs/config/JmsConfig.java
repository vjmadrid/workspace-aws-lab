package com.acme.architecture.amazon.sqs.config;

import javax.annotation.PostConstruct;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import com.acme.architecture.amazon.sqs.listener.SqsListener;
import com.acme.architecture.amazon.sqs.resolver.SqsDestinationResolver;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

@Configuration
@EnableJms
public class JmsConfig {

	private static final Logger LOG = LoggerFactory.getLogger(JmsConfig.class);

	@Autowired 
	private SQSConnectionFactory sqsConnectionFactory;

	@Autowired 
	private SqsDestinationResolver sqsDestinationResolver;
	
	@Autowired
    private SqsListener sqsListener;
	
	 @Value("${aws.sqs.queue.a}")
	 private String queueName;
	
	@PostConstruct
	public void init() {
		LOG.debug("[CONFIGURATION] Configuring JMS ...");
		preCreateQueues();
	}
	
    void preCreateQueues() {
        LOG.info("Pre-creating Queues");
    }

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		LOG.debug("[CONFIGURATION] Configuring jmsListenerContainerFactory ...");
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(sqsConnectionFactory);
		factory.setDestinationResolver(new DynamicDestinationResolver());
		//factory.setDestinationResolver(sqsDestinationResolver);
		factory.setConcurrency("3-10");
		factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		factory.setSessionTransacted(false);
		return factory;
	}
	
	@Bean
    public DefaultMessageListenerContainer jmsListenerContainer() {
		
        DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
        dmlc.setConnectionFactory(sqsConnectionFactory);
        dmlc.setDestinationName(queueName);
        dmlc.setMessageListener(sqsListener);

        return dmlc;
    }

	@Bean
	public JmsTemplate jmsTemplate() {
		LOG.debug("[CONFIGURATION] Configuring jmsTemplate ...");
		JmsTemplate template = new JmsTemplate(sqsConnectionFactory);
		//template.setDestinationResolver(sqsDestinationResolver);
		//template.setDefaultDestinationName(queueName);
        //template.setDeliveryPersistent(false);
		return template;
	}
	
	private final AWSCredentialsProvider awsCredentialsProvider = new AWSCredentialsProvider() {
        @Override
        public AWSCredentials getCredentials() {
            return new BasicAWSCredentials("", "");
        }

        @Override
        public void refresh() {

        }
    };

}
