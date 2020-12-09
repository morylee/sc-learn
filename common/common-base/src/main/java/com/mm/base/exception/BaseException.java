package com.mm.base.exception;

import com.mm.base.support.BaseResponse;
import com.mm.base.support.HttpCode;
import com.mm.base.util.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;

/**
 * @author mory.lee
 */
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

	public BaseResponse handler() {
		BaseResponse baseResponse = ResponseUtil.buildResponse(getHttpCode());
		if (StringUtils.isNotBlank(getMessage())) {
			baseResponse.setMessage(getMessage());
		}
		return baseResponse;
	}

}
