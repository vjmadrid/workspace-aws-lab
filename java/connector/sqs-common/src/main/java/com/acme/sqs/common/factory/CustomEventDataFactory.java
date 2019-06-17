package com.acme.sqs.common.factory;
import java.util.Date;

import com.acme.sqs.common.entity.CustomEvent;
import com.acme.sqs.common.enumerate.CustomEventStatusEnum;
import com.acme.sqs.common.enumerate.CustomEventTypeEnum;

import io.advantageous.boon.json.JsonFactory;

public final class CustomEventDataFactory {

	public static CustomEvent create(final Long taskId, final CustomEventTypeEnum type, final CustomEventStatusEnum status) {
		final CustomEvent customMessage = new CustomEvent();
		customMessage.setCreationDate(new Date());
		customMessage.setTaskId(taskId);
		customMessage.setType(type);
		customMessage.setStatus(status);
		return customMessage;
	}
	
	public static CustomEvent createByJSON(final String json) {
		return JsonFactory.fromJson(json, CustomEvent.class);
	}
	
}
