package com.acme.sqs.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.sqs.common.config.constant.SQSCommonSpringConfigConstant;

@Configuration
@ComponentScan(basePackages = { SQSCommonSpringConfigConstant.BASE_PACKAGE })
public class SQSCommonSpringConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(SQSCommonSpringConfig.class);

}
