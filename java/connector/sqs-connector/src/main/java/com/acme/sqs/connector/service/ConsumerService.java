package com.acme.sqs.connector.service;

import java.io.Serializable;

public interface ConsumerService {

	public <T extends Serializable> void process(T value); 
}
