package com.mm.exception;

import com.mm.support.HttpCode;

/**
 * @author mory.lee
 */
public class NotFoundException extends BaseException {

	private static final long serialVersionUID = -5428607208395998811L;

	public NotFoundException() {
	}

	public NotFoundException(Throwable ex) {
		super(ex);
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, Throwable ex) {
		super(message, ex);
	}

	@Override
	protected HttpCode getHttpCode() {
		return HttpCode.NOT_FOUND;
	}

}
