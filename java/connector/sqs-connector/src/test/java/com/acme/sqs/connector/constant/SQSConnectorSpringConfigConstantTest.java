package com.acme.sqs.connector.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import es.dinersclub.architecture.testing.util.JUnitTestBuilder;

public class SQSConnectorSpringConfigConstantTest {

	@Test
	public void checkWellFormattedClass() throws NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		JUnitTestBuilder.assertUtilityClassWellDefined(SQSConnectorSpringConfigConstant.class);
	}

}
