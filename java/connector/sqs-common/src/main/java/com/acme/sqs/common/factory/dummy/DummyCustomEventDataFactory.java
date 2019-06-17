package com.acme.sqs.common.factory.dummy;
import java.util.ArrayList;
import java.util.List;

import com.acme.sqs.common.constant.CustomEventTestConstant;
import com.acme.sqs.common.entity.CustomEvent;
import com.acme.sqs.common.factory.CustomEventDataFactory;

public final class DummyCustomEventDataFactory {

	public static CustomEvent createSampleDefault() {
		return CustomEventDataFactory.create(CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TASK_ID,CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TYPE,CustomEventTestConstant.TEST_CUSTOM_EVENT_1_STATUS);
	}
	
	public static List<CustomEvent> createSampleList() {
		final List<CustomEvent> list = new ArrayList<>();
		list.add(CustomEventDataFactory.create(CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TASK_ID,CustomEventTestConstant.TEST_CUSTOM_EVENT_1_TYPE,CustomEventTestConstant.TEST_CUSTOM_EVENT_1_STATUS));
		list.add(CustomEventDataFactory.create(CustomEventTestConstant.TEST_CUSTOM_EVENT_2_TASK_ID,CustomEventTestConstant.TEST_CUSTOM_EVENT_2_TYPE,CustomEventTestConstant.TEST_CUSTOM_EVENT_2_STATUS));
		list.add(CustomEventDataFactory.create(CustomEventTestConstant.TEST_CUSTOM_EVENT_3_TASK_ID,CustomEventTestConstant.TEST_CUSTOM_EVENT_3_TYPE,CustomEventTestConstant.TEST_CUSTOM_EVENT_3_STATUS));
		list.add(CustomEventDataFactory.create(CustomEventTestConstant.TEST_CUSTOM_EVENT_4_TASK_ID,CustomEventTestConstant.TEST_CUSTOM_EVENT_4_TYPE,CustomEventTestConstant.TEST_CUSTOM_EVENT_4_STATUS));
		list.add(CustomEventDataFactory.create(CustomEventTestConstant.TEST_CUSTOM_EVENT_5_TASK_ID,CustomEventTestConstant.TEST_CUSTOM_EVENT_5_TYPE,CustomEventTestConstant.TEST_CUSTOM_EVENT_5_STATUS));
		return list;
	}
	
}
