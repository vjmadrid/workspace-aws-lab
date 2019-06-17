package com.acme.architecture.amazon.sqs.aplication;

import org.junit.Test;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;

public class ApplicationTests {

	private static final AWSCredentials credentials;

    static {
        // put your accesskey and secretkey here
        credentials = new BasicAWSCredentials(
            "123456", 
            "changeit"
        );
    }
	
	@Test
	public void contextLoads() {
	
		// Set up the client
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4576", Regions.US_EAST_1.getName()))
            .build();
	
     // Monitoring
        GetQueueAttributesRequest getQueueAttributesRequest = new GetQueueAttributesRequest("test-queue").withAttributeNames("All");
        GetQueueAttributesResult getQueueAttributesResult = sqs.getQueueAttributes(getQueueAttributesRequest);
        
        System.out.println(String.format("The number of messages on the queue: %s", getQueueAttributesResult.getAttributes()
            .get("ApproximateNumberOfMessages")));
        System.out.println(String.format("The number of messages in flight: %s", getQueueAttributesResult.getAttributes()
            .get("ApproximateNumberOfMessagesNotVisible")));
        
	}

}
