package com.acme.sqs.common.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.acme.sqs.common.constant.CustomTaskTestConstant;
import com.acme.sqs.common.entity.CustomTask;
import com.acme.sqs.common.enumerate.CustomTaskTypeEnum;

public class CustomTaskDataFactoryTest {

	@Before
	public void init() {
		
	}

	@Test
	public void shouldCreate() {
		CustomTask result = CustomTaskDataFactory.create(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_ID,CustomTaskTestConstant.TEST_CUSTOM_TASK_1_DATA,CustomTaskTypeEnum.CLEAN);

		assertNotNull(result);
		assertEquals(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_ID,result.getId());
		assertEquals(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_DATA,result.getData());
		assertEquals(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_TYPE,result.getType());
	}
	
	@Test
	public void shouldCreateByJSON() {
		CustomTask customTaskTest = CustomTaskDataFactory.create(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_ID,CustomTaskTestConstant.TEST_CUSTOM_TASK_1_DATA,CustomTaskTypeEnum.CLEAN);
		CustomTask result = CustomTaskDataFactory.createByJSON(customTaskTest.toJSON());
		
		assertNotNull(result);
		assertEquals(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_ID,result.getId());
		assertEquals(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_DATA,result.getData());
		assertEquals(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_TYPE,result.getType());
	}	
	
	@Test
	public void shouldCreateDefaultConstructor() {
		assertNotNull(new CustomTaskDataFactory());
	}

}