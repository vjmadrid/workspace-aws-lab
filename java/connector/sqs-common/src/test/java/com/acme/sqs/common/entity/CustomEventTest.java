package com.acme.sqs.common.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.acme.sqs.common.constant.CustomEventTestConstant;
import com.acme.sqs.common.entity.CustomEvent;
import com.acme.sqs.common.factory.dummy.DummyCustomEventDataFactory;

public class CustomEventTest {
	
	private CustomEvent customEvent;

	private CustomEvent anotherCustomEvent;

	private CustomEvent cloneCustomEvent;
	
	@Before
	public void init() {
		CustomEvent temp = DummyCustomEventDataFactory.createSampleDefault();
		customEvent = temp;
		cloneCustomEvent =  temp;
		anotherCustomEvent = DummyCustomEventDataFactory.createSampleDefault();
		anotherCustomEvent.setTaskId(2L);
	}
	
	@Test
	public void equalsMethodCheckTheType() {
		assertFalse(customEvent.equals("a string"));
	}

	@Test
	public void equalsMehtodCheckSameObject() throws Exception {
		assertTrue(customEvent.equals(customEvent));
	}
	
	@Test
	public void equalsMehtodCheckIdField() throws Exception {
		assertFalse(customEvent.equals(anotherCustomEvent));
	}

	@Test
	public void equalsMehtodCheckIdFieldEquals() throws Exception {
		assertTrue(customEvent.equals(cloneCustomEvent));
	}

	@Test
	public void hashproductMethodBasedInTheIDField() throws Exception {
		assertNotSame(customEvent.hashCode(), anotherCustomEvent.hashCode());
	}

		
	@Test
	public void shouldHaveADescriptiveToStringMethod() {
		assertNotSame(-1, customEvent.toString().indexOf(CustomEvent.class.getSimpleName()));
		assertNotSame(-1,
				customEvent.toString().indexOf("taskId=".concat(CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TASK_ID.toString())));
	}

	@Test
	public void shouldHasMethodAccessors() {
		assertNotNull(customEvent.getTaskId());
		assertNotNull(customEvent.getType());
		assertNotNull(customEvent.getStatus());
		assertNotNull(customEvent.getCreationDate());
	}

}
