package com.acme.sqs.common.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.acme.sqs.common.constant.CustomTaskTestConstant;
import com.acme.sqs.common.factory.dummy.DummyCustomTaskDataFactory;

public class CustomTaskTest {
	
	private CustomTask customTask;

	private CustomTask anotherCustomTask;

	private CustomTask cloneCustomTask;
	
	@Before
	public void init() {
		customTask = DummyCustomTaskDataFactory.createSampleDefault();
		cloneCustomTask =  DummyCustomTaskDataFactory.createSampleDefault();
		anotherCustomTask = DummyCustomTaskDataFactory.createSampleDefault();
		anotherCustomTask.setId(2L);
	}
	
	@Test
	public void equalsMethodCheckTheType() {
		assertFalse(customTask.equals("a string"));
	}

	@Test
	public void equalsMehtodCheckSameObject() throws Exception {
		assertTrue(customTask.equals(customTask));
	}
	
	@Test
	public void equalsMehtodCheckIdField() throws Exception {
		assertFalse(customTask.equals(anotherCustomTask));
	}

	@Test
	public void equalsMehtodCheckIdFieldEquals() throws Exception {
		assertTrue(customTask.equals(cloneCustomTask));
	}

	@Test
	public void hashproductMethodBasedInTheIDField() throws Exception {
		assertNotSame(customTask.hashCode(), anotherCustomTask.hashCode());
	}
		
	@Test
	public void shouldHaveADescriptiveToStringMethod() {
		assertNotSame(-1, customTask.toString().indexOf(CustomTask.class.getSimpleName()));
		assertNotSame(-1, customTask.toString().indexOf("data=".concat(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_DATA.toString())));
	}

	@Test
	public void shouldHasMethodAccessors() {
		assertNotNull(customTask.getId());
		assertNotNull(customTask.getData());
		assertNotNull(customTask.getType());
	}

}
