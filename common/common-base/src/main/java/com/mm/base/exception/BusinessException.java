package com.mm.base.exception;

import com.mm.base.support.HttpCode;

/**
 * @author mory.lee
 */
public class BusinessException extends BaseException {

	private static final long serialVersionUID = 8666592418833558948L;

	public BusinessException() {

	}

	public BusinessException(Throwable ex) {
		super(ex);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable ex) {
		super(message, ex);
	}

	@Override
	protected HttpCode getHttpCode() {
		return HttpCode.INTERNAL_SERVER_ERROR;
	}

}
