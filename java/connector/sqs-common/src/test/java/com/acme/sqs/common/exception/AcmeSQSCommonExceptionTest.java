package com.acme.sqs.common.exception;

import com.acme.architecture.common.constant.GlobalConstant;

import es.dinersclub.architecture.testing.exception.test.AbstractExceptionTest;

public class AcmeSQSCommonExceptionTest extends AbstractExceptionTest {

	@Override
	protected Exception getExceptionWithParameter() {
		return new AcmeSQSCommonException(GlobalConstant.COMPANY_NAME);
	}

}
