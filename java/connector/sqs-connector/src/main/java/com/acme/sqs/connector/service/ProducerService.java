package com.acme.sqs.connector.service;

import java.io.Serializable;

public interface ProducerService {

	public <T extends Serializable> void send(String queue, T value); 
}
