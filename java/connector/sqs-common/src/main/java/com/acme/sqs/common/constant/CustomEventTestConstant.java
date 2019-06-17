package com.acme.sqs.common.constant;

import com.acme.sqs.common.enumerate.CustomEventStatusEnum;
import com.acme.sqs.common.enumerate.CustomEventTypeEnum;

public final class CustomEventTestConstant {

	private CustomEventTestConstant() {
	}
	
	public static final int TEST_NUM_EVENTS = 5;
	
	public static final Long TEST_CUSTOM_EVENT_1_TASK_ID = 1L;
	public static final CustomEventTypeEnum TEST_CUSTOM_EVENT_1_TYPE = CustomEventTypeEnum.CLEAN;
	public static final CustomEventStatusEnum TEST_CUSTOM_EVENT_1_STATUS = CustomEventStatusEnum.STARTED;
	
	public static final Long TEST_CUSTOM_EVENT_2_TASK_ID = 1L;
	public static final CustomEventTypeEnum TEST_CUSTOM_EVENT_2_TYPE = CustomEventTypeEnum.CLEAN;
	public static final CustomEventStatusEnum TEST_CUSTOM_EVENT_2_STATUS = CustomEventStatusEnum.STARTED;
			
	public static final Long TEST_CUSTOM_EVENT_3_TASK_ID = 1L;
	public static final CustomEventTypeEnum TEST_CUSTOM_EVENT_3_TYPE = CustomEventTypeEnum.CLEAN;
	public static final CustomEventStatusEnum TEST_CUSTOM_EVENT_3_STATUS = CustomEventStatusEnum.STARTED;
	
	public static final Long TEST_CUSTOM_EVENT_4_TASK_ID = 1L;
	public static final CustomEventTypeEnum TEST_CUSTOM_EVENT_4_TYPE = CustomEventTypeEnum.CLEAN;
	public static final CustomEventStatusEnum TEST_CUSTOM_EVENT_4_STATUS = CustomEventStatusEnum.STARTED;
	
	public static final Long TEST_CUSTOM_EVENT_5_TASK_ID = 1L;
	public static final CustomEventTypeEnum TEST_CUSTOM_EVENT_5_TYPE = CustomEventTypeEnum.CLEAN;
	public static final CustomEventStatusEnum TEST_CUSTOM_EVENT_5_STATUS = CustomEventStatusEnum.STARTED;
	
}
