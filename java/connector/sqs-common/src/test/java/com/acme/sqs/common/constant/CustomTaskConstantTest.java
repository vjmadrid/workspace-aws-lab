package com.acme.sqs.common.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import es.dinersclub.architecture.testing.util.JUnitTestBuilder;

public class CustomTaskConstantTest {

	@Test
	public void checkWellFormattedClass() throws NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		JUnitTestBuilder.assertUtilityClassWellDefined(CustomTaskConstant.class);
	}

}
