package com.acme.sqs.connector.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.sqs.connector.constant.SQSConnectorSpringConfigConstant;

@Configuration
@ComponentScan(basePackages = { SQSConnectorSpringConfigConstant.BASE_PACKAGE })
public class SQSConnectorSpringConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(SQSConnectorSpringConfig.class);

}
