package com.acme.sqs.common.factory;
import com.acme.sqs.common.entity.CustomTask;
import com.acme.sqs.common.enumerate.CustomTaskTypeEnum;

import io.advantageous.boon.json.JsonFactory;

public final class CustomTaskDataFactory {

	public static CustomTask create(final Long id, final String data,final CustomTaskTypeEnum type) {
		final CustomTask customTask = new CustomTask();
		customTask.setId(1L);
		customTask.setData(data);
		customTask.setType(type);
		return customTask;
	}
	
	public static CustomTask createByJSON(final String json) {
		return JsonFactory.fromJson(json, CustomTask.class);
	}
	
}
