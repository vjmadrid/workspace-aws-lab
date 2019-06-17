package com.acme.architecture.amazon.sqs.config.aws;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.acme.architecture.common.constant.SpringConfigConstant;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.AwsRegionProvider;
import com.amazonaws.regions.DefaultAwsRegionProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.RegionUtils;

@Configuration
@Profile(SpringConfigConstant.PROFILE_DEFAULT)
@PropertySource("classpath:application.properties")
public class AwsConfig {

	private static final Logger LOG = LoggerFactory.getLogger(AwsConfig.class);

	@Value("${aws.credentials.accessKey}")
	private String accessKey;

	@Value("${aws.credentials.secretKey}")
	private String secretKey;

	@Value("${aws.region.static}")
	private String region;

	@PostConstruct
	public void init() {
		LOG.debug("[CONFIGURATION] Configuring AWS ...");
	}

	@Bean
	public AWSCredentialsProvider awsCredentialsProvider() {
		LOG.debug("[CONFIGURATION] Configuring awsCredentialsProvider ...");
		return new InstanceProfileCredentialsProvider(false);
	}
	
//	@Bean
//    public AWSCredentialsProvider awsCredentialsProvider() {
//        /*
//         * http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/
//         * credentials.html
//         */
//        return new DefaultAWSCredentialsProviderChain();
//    }
	
	@Bean
	public AWSCredentialsProvider awsCredentialsFileProvider() {
		LOG.debug("[CONFIGURATION] Configuring awsCredentialsFileProvider ...");
		// File (~/.aws/credentials).
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (~/.aws/credentials), and is in valid format.",
                    e);
        }
		
		return credentialsProvider;
	}

	@Bean
	public Region awsRegion() {
		LOG.debug("[CONFIGURATION] Configuring awsRegion ...");
		Region awsRegion;

		if (region != null && !region.isEmpty()) {
			awsRegion = RegionUtils.getRegion(region);
		} else {
			AwsRegionProvider regionProvider = new DefaultAwsRegionProviderChain();
			awsRegion = RegionUtils.getRegion(regionProvider.getRegion());
		}

		if (awsRegion == null) {
			throw new BeanInitializationException("Unable to determine AWS region");
		}

		return awsRegion;
	}

}
