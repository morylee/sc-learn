package com.mm.base.exception;

import com.mm.base.support.HttpCode;

/**
 * @author mory.lee
 */
public class IllegalArgumentException extends BaseException {

	private static final long serialVersionUID = 8513270528651845608L;

	public IllegalArgumentException() {

	}

	public IllegalArgumentException(Throwable ex) {
		super(ex);
	}

	public IllegalArgumentException(String message) {
		super(message);
	}

	public IllegalArgumentException(String message, Throwable ex) {
		super(message, ex);
	}

	@Override
	protected HttpCode getHttpCode() {
		return HttpCode.BAD_REQUEST;
	}

}
