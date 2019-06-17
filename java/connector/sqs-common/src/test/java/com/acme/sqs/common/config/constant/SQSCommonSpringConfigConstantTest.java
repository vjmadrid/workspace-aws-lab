package com.acme.sqs.common.config.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import es.dinersclub.architecture.testing.util.JUnitTestBuilder;

public class SQSCommonSpringConfigConstantTest {

	@Test
	public void checkWellFormattedClass() throws NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		JUnitTestBuilder.assertUtilityClassWellDefined(SQSCommonSpringConfigConstant.class);
	}

}
