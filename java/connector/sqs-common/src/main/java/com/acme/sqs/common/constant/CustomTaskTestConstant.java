package com.acme.sqs.common.constant;

import com.acme.sqs.common.enumerate.CustomTaskTypeEnum;

public final class CustomTaskTestConstant {

	private CustomTaskTestConstant() {
	}
	
	public static final int TEST_NUM_TASKS = 4;
	
	public static final Long TEST_CUSTOM_TASK_1_ID = 1L;
	public static final String TEST_CUSTOM_TASK_1_DATA = "Test Description 1";
	public static final CustomTaskTypeEnum TEST_CUSTOM_TASK_1_TYPE = CustomTaskTypeEnum.CLEAN;

	public static final Long TEST_CUSTOM_TASK_2_ID = 2L;
	public static final String TEST_CUSTOM_TASK_2_DATA = "Test Description 2";
	public static final CustomTaskTypeEnum TEST_CUSTOM_TASK_2_TYPE = CustomTaskTypeEnum.CLEAN;
	
	public static final Long TEST_CUSTOM_TASK_3_ID = 3L;
	public static final String TEST_CUSTOM_TASK_3_DATA = "Test Description 3";
	public static final CustomTaskTypeEnum TEST_CUSTOM_TASK_3_TYPE = CustomTaskTypeEnum.REFRESH;

	public static final Long TEST_CUSTOM_TASK_4_ID = 4L;
	public static final String TEST_CUSTOM_TASK_4_DATA = "Test Description 4";
	public static final CustomTaskTypeEnum TEST_CUSTOM_TASK_4_TYPE = CustomTaskTypeEnum.UPDATE;
	
}
