package com.acme.architecture.amazon.sqs.validator;

import java.util.Map;

import com.amazonaws.services.sqs.AmazonSQS;

public enum SQSValidator {
	
	INSTANCE;
	
	public boolean isNull(AmazonSQS sqs) {
		return (sqs == null);
	}
	
	public boolean isNotNull(AmazonSQS sqs) {
		return (sqs != null);
	}
	
	public boolean isNull(Map<String, String> queueAttributes) {
		return (queueAttributes == null);
	}

	public boolean isNotNull(Map<String, String> queueAttributes) {
		return (queueAttributes != null);
	}

	public boolean isValid(Map<String, String> queueAttributes) {
		return (isNotNull(queueAttributes) && !queueAttributes.isEmpty());
	}

}
