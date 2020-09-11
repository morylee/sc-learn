package com.mm.exception;

import com.mm.constant.HttpCode;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 8053680912554731882L;

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
