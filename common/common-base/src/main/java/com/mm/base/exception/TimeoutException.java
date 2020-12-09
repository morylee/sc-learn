package com.mm.base.exception;

import com.mm.base.support.HttpCode;

public class TimeoutException extends BaseException {

	public TimeoutException() {
	}

	public TimeoutException(Throwable ex) {
		super(ex);
	}

	public TimeoutException(String message) {
		super(message);
	}

	public TimeoutException(String message, Throwable ex) {
		super(message, ex);
	}

	@Override
	protected HttpCode getHttpCode() {
		return HttpCode.TIMEOUT_ERROR;
	}
}
