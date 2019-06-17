package com.acme.sqs.common.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.acme.sqs.common.constant.CustomEventTestConstant;

import es.dinersclub.architecture.testing.util.JUnitTestBuilder;

public class CustomTaskTestConstantTest {

	@Test
	public void checkWellFormattedClass() throws NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		JUnitTestBuilder.assertUtilityClassWellDefined(CustomEventTestConstant.class);
	}

}
