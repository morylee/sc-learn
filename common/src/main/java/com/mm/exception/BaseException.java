package com.mm.exception;

import com.mm.constant.HttpCode;

public abstract class BaseException extends RuntimeException {

	public BaseException() {
	}

	public BaseException(Throwable ex) {
		super(ex);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(String message, Throwable ex) {
		super(message, ex);
	}

	protected abstract HttpCode getHttpCode();

}
