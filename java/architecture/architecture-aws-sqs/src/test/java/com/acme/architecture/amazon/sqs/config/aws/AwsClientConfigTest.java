package com.acme.architecture.amazon.sqs.config.aws;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.architecture.common.constant.SpringConfigConstant;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.s3.AmazonS3;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AwsClientConfig.class})
@ActiveProfiles(profiles={SpringConfigConstant.PROFILE_DEFAULT})
public class AwsClientConfigTest {
	
	@Autowired
	private ClientConfiguration awsClientConfig;
	
	@Autowired
	private AmazonEC2 amazonEC2Client;
	
	@Autowired
	private AmazonS3 amazonS3Client;
	
	@Test
	public void shouldBeInjected() {
		assertNotNull(awsClientConfig);
		assertNotNull(amazonEC2Client);
		assertNotNull(amazonS3Client);
	}
}
