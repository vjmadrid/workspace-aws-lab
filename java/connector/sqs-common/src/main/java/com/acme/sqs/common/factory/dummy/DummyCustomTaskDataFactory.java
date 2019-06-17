package com.acme.sqs.common.factory.dummy;
import java.util.ArrayList;
import java.util.List;

import com.acme.sqs.common.constant.CustomTaskTestConstant;
import com.acme.sqs.common.entity.CustomTask;
import com.acme.sqs.common.enumerate.CustomTaskTypeEnum;
import com.acme.sqs.common.factory.CustomTaskDataFactory;

public final class DummyCustomTaskDataFactory {

	public static CustomTask createSampleCLEAN() {
		return CustomTaskDataFactory.create(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_ID,CustomTaskTestConstant.TEST_CUSTOM_TASK_1_DATA,CustomTaskTypeEnum.CLEAN);
	}
	
	public static CustomTask createSampleUPDATE() {
		return CustomTaskDataFactory.create(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_ID,CustomTaskTestConstant.TEST_CUSTOM_TASK_1_DATA,CustomTaskTypeEnum.UPDATE);
	}
	
	public static CustomTask createSampleREFRESH() {
		return CustomTaskDataFactory.create(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_ID,CustomTaskTestConstant.TEST_CUSTOM_TASK_1_DATA,CustomTaskTypeEnum.REFRESH);
	}
	
	public static CustomTask createSampleDefault() {
		return createSampleCLEAN();
	}
	
	public static List<CustomTask> createSampleList() {
		final List<CustomTask> list = new ArrayList<>();
		list.add(CustomTaskDataFactory.create(CustomTaskTestConstant.TEST_CUSTOM_TASK_1_ID,CustomTaskTestConstant.TEST_CUSTOM_TASK_1_DATA,CustomTaskTestConstant.TEST_CUSTOM_TASK_1_TYPE));
		list.add(CustomTaskDataFactory.create(CustomTaskTestConstant.TEST_CUSTOM_TASK_2_ID,CustomTaskTestConstant.TEST_CUSTOM_TASK_2_DATA,CustomTaskTestConstant.TEST_CUSTOM_TASK_2_TYPE));
		list.add(CustomTaskDataFactory.create(CustomTaskTestConstant.TEST_CUSTOM_TASK_3_ID,CustomTaskTestConstant.TEST_CUSTOM_TASK_3_DATA,CustomTaskTestConstant.TEST_CUSTOM_TASK_3_TYPE));
		list.add(CustomTaskDataFactory.create(CustomTaskTestConstant.TEST_CUSTOM_TASK_4_ID,CustomTaskTestConstant.TEST_CUSTOM_TASK_4_DATA,CustomTaskTestConstant.TEST_CUSTOM_TASK_4_TYPE));
		return list;
	}
	
}
