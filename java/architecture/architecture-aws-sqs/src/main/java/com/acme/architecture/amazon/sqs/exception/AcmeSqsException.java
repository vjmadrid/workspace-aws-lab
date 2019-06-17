package com.acme.architecture.amazon.sqs.exception;

import com.acme.architecture.common.constant.GlobalConstant;
import com.acme.architecture.common.exception.AcmeException;

public class AcmeSqsException extends AcmeException {

	private static final long serialVersionUID = -449870482873284582L;

	public AcmeSqsException(String header) {
		this(header, GlobalConstant.EMPTY_STRING);
	}
	
	public AcmeSqsException(String header, String message) {
		super(new StringBuilder(header).append(message).toString());
	}

}
