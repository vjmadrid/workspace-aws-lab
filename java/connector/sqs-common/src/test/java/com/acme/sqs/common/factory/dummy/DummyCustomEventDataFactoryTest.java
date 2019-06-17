package com.acme.sqs.common.factory.dummy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.acme.sqs.common.constant.CustomEventTestConstant;
import com.acme.sqs.common.entity.CustomEvent;
import com.acme.sqs.common.factory.dummy.DummyCustomEventDataFactory;

public class DummyCustomEventDataFactoryTest {

	@Before
	public void init() {
	}

	@Test
	public void shouldCreateSampleDefault() {
		assertNotNull(DummyCustomEventDataFactory.createSampleDefault());
	}
	
	@Test
	public void shouldCreateSampleUserList() {
		List<CustomEvent> result = DummyCustomEventDataFactory.createSampleList();
		
		assertNotNull(result);
		assertEquals(CustomEventTestConstant.TEST_NUM_EVENTS,result.size());
	}
	
	@Test
	public void shouldCreateDefaultConstructor() {
		assertNotNull(new DummyCustomEventDataFactory());
	}

}