package com.acme.sqs.common.factory.dummy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.acme.sqs.common.constant.CustomTaskTestConstant;
import com.acme.sqs.common.entity.CustomTask;

public class DummyCustomTaskDataFactoryTest {

	@Before
	public void init() {
	}

	@Test
	public void shouldCreateSampleDefault() {
		assertNotNull(DummyCustomTaskDataFactory.createSampleDefault());
	}
	
	@Test
	public void shouldCreateSampleUserList() {
		List<CustomTask> result = DummyCustomTaskDataFactory.createSampleList();
		
		assertNotNull(result);
		assertEquals(CustomTaskTestConstant.TEST_NUM_TASKS,result.size());
	}
	
	@Test
	public void shouldCreateDefaultConstructor() {
		assertNotNull(new DummyCustomTaskDataFactory());
	}

}