package com.acme.sqs.common.exception;

import com.acme.architecture.common.constant.GlobalConstant;
import com.acme.architecture.common.exception.AcmeException;

public class AcmeSQSCommonException extends AcmeException {

	private static final long serialVersionUID = -2058040748847923761L;

	public AcmeSQSCommonException(String header) {
		this(header, GlobalConstant.EMPTY_STRING);
	}
	
	public AcmeSQSCommonException(String header, String message) {
		super(new StringBuilder(header).append(message).toString());
	}

}
