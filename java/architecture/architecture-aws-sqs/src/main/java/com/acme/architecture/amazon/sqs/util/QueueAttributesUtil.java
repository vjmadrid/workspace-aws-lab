package com.acme.architecture.amazon.sqs.util;

import java.util.HashMap;
import java.util.Map;

public enum QueueAttributesUtil {
	
	INSTANCE;
	
	public Map<String, String> configFifo() {
		Map<String, String> queueAttributes = new HashMap<String, String>();
        queueAttributes.put("FifoQueue", "true");
        queueAttributes.put("ContentBasedDeduplication", "true");
        return queueAttributes;
	}
}
