package com.acme.architecture.amazon.sqs.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClient;

@Configuration
@Profile("default")
public class DevelopmentSqsConfig {

	private static final Logger LOG = LoggerFactory.getLogger(DevelopmentSqsConfig.class);

	@Value("${aws.region.static}")
    String awsRegion;

    @Value("${aws.sqs.endpoint}")
    String localStackSqsUrl;
    
    @Value("${aws.sqs.queue.a.name}")
    String queueName;

	@PostConstruct
	public void init() {
		LOG.debug("[CONFIGURATION] Configuring SQS in DEV ...");
	}

	@Bean
    public AmazonSQSAsync amazonSqsAsync() {
		LOG.debug("[CONFIGURATION] Configuring amazonSqsAsync int DEV");
        return AmazonSQSAsyncClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(localStackSqsUrl, awsRegion))
                .build();
    }
	
	@Bean
    public AmazonSQSClient amazonSqsClient() {
		LOG.debug("[CONFIGURATION] Configuring amazonSqsClient int DEV");
        AmazonSQSClient amazonSQSClient = new AmazonSQSClient(new BasicAWSCredentials("",""));
        amazonSQSClient.setEndpoint(localStackSqsUrl);
        amazonSQSClient.createQueue(queueName);
        return amazonSQSClient;
    }
	
}
