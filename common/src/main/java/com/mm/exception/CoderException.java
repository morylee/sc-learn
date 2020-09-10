package com.mm.exception;

import com.mm.constant.HttpCode;

public class CoderException extends BaseException {

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
