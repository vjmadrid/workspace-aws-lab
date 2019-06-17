package com.acme.architecture.amazon.sqs.resolver;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.jms.support.destination.DynamicDestinationResolver;
import org.springframework.stereotype.Component;

import com.acme.architecture.common.constant.GlobalConstant;

@Component
public class SqsDestinationResolver extends DynamicDestinationResolver implements DestinationResolver  {

	private static final Logger LOG = LoggerFactory.getLogger(SqsDestinationResolver.class);
	
	@Override
	public Destination resolveDestinationName(Session session, String destinationName, boolean pubSubDomain)
			throws JMSException {
		 String newDestinationName = resolveDestinationName(destinationName);
		 return super.resolveDestinationName(session, newDestinationName, pubSubDomain);
	
	}
	
	private String resolveDestinationName(final String destinationName) {
		LOG.info("Resolving destination name {}", destinationName);
		return destinationName.replace(GlobalConstant.PHRASE_END, GlobalConstant.HYPHEN);
	}
	
}
