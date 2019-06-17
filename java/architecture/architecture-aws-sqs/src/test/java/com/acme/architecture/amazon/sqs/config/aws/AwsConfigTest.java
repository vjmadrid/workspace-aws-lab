package com.acme.architecture.amazon.sqs.config.aws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.architecture.common.constant.SpringConfigConstant;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AwsConfig.class})
@ActiveProfiles(profiles={SpringConfigConstant.PROFILE_DEFAULT})
public class AwsConfigTest {
	
	@Autowired
	private AWSCredentialsProvider awsCredentialsProvider;
	
	@Autowired
	private AWSCredentialsProvider awsCredentialsFileProvider;
	
	@Autowired
	Region awsRegion;
	
	@Test
	public void shouldCheckRegion() {
		assertEquals("amazonaws.com",awsRegion.getDomain());
		assertEquals("eu-west-1",awsRegion.getName());
	}
	
	@Test
	public void shouldBeInjected() {
		assertNotNull(awsCredentialsProvider);
		assertNotNull(awsCredentialsFileProvider);
		assertNotNull(awsRegion);
	}
}
