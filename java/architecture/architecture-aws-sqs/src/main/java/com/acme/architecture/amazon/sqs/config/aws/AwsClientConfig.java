package com.acme.architecture.amazon.sqs.config.aws;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.acme.architecture.amazon.sqs.entity.ProxyDetails;
import com.acme.architecture.common.constant.SpringConfigConstant;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
@Profile(SpringConfigConstant.PROFILE_DEFAULT)
@PropertySource("classpath:application.properties")
public class AwsClientConfig {

	private static final Logger LOG = LoggerFactory.getLogger(AwsClientConfig.class);

	@Value("${aws.client.useProxy}")
	private Boolean useProxy;

	@Value("${aws.client.protocol}")
	private String clientProtocol;

	@Value("${aws.client.proxy.host}")
	private String clientProxyHost;

	@Value("${aws.client.proxy.port}")
	private Integer clientProxyPort;

	@Value("${aws.client.connection.timeout}")
	private Integer clientConnectionTimeout;

	@Value("${aws.client.max.errorRetry}")
	private Integer clientMaxErrorRetry;

	@Autowired
	Region awsRegion;
	
	@PostConstruct
	public void init() {
		LOG.debug("[CONFIGURATION] Configuring AWS Clients ...");
	}

	@Bean
	public ClientConfiguration awsClientConfig(final ProxyDetails proxyDetails) {
		LOG.debug("[CONFIGURATION] Configuring awsClientConfig ...");
		ClientConfiguration clientConfig = new ClientConfiguration();

		if (useProxy) {
			clientConfig.setProxyHost(clientProxyHost);
			clientConfig.setProxyPort(clientProxyPort);
		} else if (proxyDetails != null) {
			clientConfig.setProxyHost(proxyDetails.getHost());
			clientConfig.setProxyPort(proxyDetails.getPort());
		}

		clientConfig.setProtocol(Protocol.valueOf(clientProtocol.toUpperCase()));
		clientConfig.setConnectionTimeout(clientConnectionTimeout);
		clientConfig.setMaxErrorRetry(clientMaxErrorRetry);

		return clientConfig;
	}

	@Bean
	public AmazonEC2 amazonEC2Client(final AWSCredentialsProvider awsCredentialsProvider,
			final ClientConfiguration awsClientConfig, final Region awsRegion) {
		LOG.debug("[CONFIGURATION] Configuring amazonEC2Client ...");
		return AmazonEC2ClientBuilder.standard().withCredentials(awsCredentialsProvider)
				.withClientConfiguration(awsClientConfig).withRegion(awsRegion.getName()).build();
	}
	
	@Bean
    public AmazonS3 amazonS3Client(final AWSCredentialsProvider awsCredentialsProvider, 
        final ClientConfiguration awsClientConfig, final Region awsRegion) {
		LOG.debug("[CONFIGURATION] Configuring amazonS3Client ...");
        return AmazonS3ClientBuilder.standard()
            .withCredentials(awsCredentialsProvider)
            .withClientConfiguration(awsClientConfig)
            .withRegion(awsRegion.getName())
            .build();
    }

}
