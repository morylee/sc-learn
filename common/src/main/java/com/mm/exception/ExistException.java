package com.mm.exception;

import com.mm.constant.HttpCode;

public class ExistException extends BaseException {

	private static final long serialVersionUID = -6334021504866714477L;

	public ExistException() {
	}

	public ExistException(Throwable ex) {
		super(ex);
	}

	public ExistException(String message) {
		super(message);
	}

	public ExistException(String message, Throwable ex) {
		super(message, ex);
	}

	@Override
	protected HttpCode getHttpCode() {
		return HttpCode.ALREADY_EXIST;
	}

}
