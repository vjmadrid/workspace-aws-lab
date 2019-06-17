package com.acme.sqs.common.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.acme.sqs.common.constant.CustomEventTestConstant;
import com.acme.sqs.common.entity.CustomEvent;
import com.acme.sqs.common.factory.CustomEventDataFactory;

public class CustomEventDataFactoryTest {

	@Before
	public void init() {
		
	}

	@Test
	public void shouldCreate() {
		CustomEvent result = CustomEventDataFactory.create(CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TASK_ID,CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TYPE, CustomEventTestConstant.TEST_CUSTOM_EVENT_1_STATUS);
		
		assertNotNull(result);
		assertNotNull(result.getTaskId());
		assertEquals(CustomEventTestConstant.TEST_CUSTOM_EVENT_1_STATUS,result.getStatus());
		assertEquals(CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TYPE,result.getType());
		assertNotNull(result.getCreationDate());
	}
	
	@Test
	public void shouldCreateByJSON() {
		CustomEvent customEventTest = CustomEventDataFactory.create(CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TASK_ID,CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TYPE, CustomEventTestConstant.TEST_CUSTOM_EVENT_1_STATUS);
		CustomEvent result = CustomEventDataFactory.createByJSON(customEventTest.toJSON());
		
		assertNotNull(result);
		assertNotNull(result.getTaskId());
		assertEquals(CustomEventTestConstant.TEST_CUSTOM_EVENT_1_STATUS,result.getStatus());
		assertEquals(CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TYPE,result.getType());
		assertNotNull(result.getCreationDate());
	}	
	
	@Test
	public void shouldCreateDefaultConstructor() {
		assertNotNull(new CustomEventDataFactory());
	}

}