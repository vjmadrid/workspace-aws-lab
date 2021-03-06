package com.acme.sqs.common.enumerate;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import es.dinersclub.architecture.testing.util.JUnitTestBuilder;

public class CustomEventStatusEnumTest {

	@Test
	public void checkValueOfEnum() throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		JUnitTestBuilder.superficialEnumCodeCoverage(CustomEventStatusEnum.class);
	}

}
