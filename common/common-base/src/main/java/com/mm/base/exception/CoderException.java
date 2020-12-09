package com.mm.base.exception;

import com.mm.base.support.HttpCode;

/**
 * @author mory.lee
 */
public class CoderException extends BaseException {

	private static final long serialVersionUID = 5167273687497486748L;

	public CoderException() {
    }

    public CoderException(Throwable ex) {
        super(ex);
    }

    public CoderException(String message) {
        super(message);
    }

    public CoderException(String message, Throwable ex) {
        super(message, ex);
    }

    @Override
    public HttpCode getHttpCode() {
        return HttpCode.BAD_REQUEST;
    }

}
