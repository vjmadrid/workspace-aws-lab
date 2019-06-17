package com.acme.sqs.common.extractor;

import com.acme.architecture.amazon.sqs.extractor.MessageExtractor;
import com.acme.sqs.common.entity.CustomEvent;

public class SQSMessageExtractor extends GenericMessageExtractor<CustomEvent> {

	public SQSMessageExtractor() {
		super(CustomEvent.class);
	}

}
