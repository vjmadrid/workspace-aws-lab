package com.acme.sqs.common.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.acme.sqs.common.constant.CustomEventConstant;

import es.dinersclub.architecture.testing.util.JUnitTestBuilder;

public class CustomEventConstantTest {

	@Test
	public void checkWellFormattedClass() throws NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		JUnitTestBuilder.assertUtilityClassWellDefined(CustomEventConstant.class);
	}

}
