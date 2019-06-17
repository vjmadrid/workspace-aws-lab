package com.acme.architecture.amazon.sqs.config;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acme.architecture.amazon.sqs.config.constant.SQSConstant;
import com.acme.architecture.amazon.sqs.entity.ProxyDetails;
import com.acme.architecture.amazon.sqs.factory.ProxyDetailsDataFactory;

@Configuration
public class ProxyConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProxyConfig.class);
	
	@PostConstruct
    public void init() {
		LOG.debug("[CONFIGURATION] Configuring Proxy ...");
    }
	
	@Bean
    public ProxyDetails proxyDetails() {
		LOG.debug("[CONFIGURATION] Configuring proxy details ...");
        ProxyDetails details = null;
        
        final String httpsProxyEnvironmentVar = System.getenv(SQSConstant.ENV_HTTPS_PROXY);
        
        if(httpsProxyEnvironmentVar != null && !httpsProxyEnvironmentVar.isEmpty()) {
            LOG.debug(SQSConstant.ENV_HTTPS_PROXY + " environment variable detected: " + httpsProxyEnvironmentVar);
            try {
                URL httpProxyUrl = new URL(httpsProxyEnvironmentVar);
                details = ProxyDetailsDataFactory.create(httpProxyUrl.getHost(), httpProxyUrl.getPort());
                LOG.debug("Proxy details set to host: " + details.getHost() + ", port: " + details.getPort());
            } catch (MalformedURLException e) {
            	LOG.warn("Unable to parse " + SQSConstant.ENV_HTTPS_PROXY + " environment variable", e);
            }
        } else {
        	LOG.debug(SQSConstant.ENV_HTTPS_PROXY + " environment variable not found, no proxy details set");
        }
        
        return details;
	}

}
