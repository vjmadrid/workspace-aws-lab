package com.acme.architecture.amazon.sqs.exception.util;

import org.slf4j.Logger;

import com.amazonaws.AmazonServiceException;

public enum AmazonServiceExceptionUtil {

	INSTANCE;
	
	public void showDetail(Logger LOG, AmazonServiceException ase) {
		LOG.debug("Error Message: {}",ase.getMessage());
		LOG.debug("HTTP Status Code: {}",ase.getStatusCode());
		LOG.debug("AWS Error Code: {}",ase.getErrorCode());
		LOG.debug("Error Type: {}",ase.getErrorType());
		LOG.debug("Request ID: {}",ase.getRequestId());
	}
	
}
