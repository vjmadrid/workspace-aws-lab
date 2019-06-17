package com.acme.architecture.amazon.sqs.exception;

import com.acme.architecture.amazon.sqs.exception.AcmeSqsException;
import com.acme.architecture.common.constant.GlobalConstant;

import es.dinersclub.architecture.testing.exception.test.AbstractExceptionTest;

public class AcmeSQSCommonExceptionTest extends AbstractExceptionTest {

	@Override
	protected Exception getExceptionWithParameter() {
		return new AcmeSqsException(GlobalConstant.COMPANY_NAME);
	}

}
