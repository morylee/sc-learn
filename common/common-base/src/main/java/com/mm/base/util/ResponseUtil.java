package com.mm.base.util;

import com.mm.base.support.BaseResponse;
import com.mm.base.support.HttpCode;

public class ResponseUtil<T> {

	public static BaseResponse buildSuccessResponse(){
		return buildSuccessResponse(null);
	}

	public static BaseResponse buildSuccessResponse(Object data){
		return buildResponse(HttpCode.OK, data);
	}

	public static BaseResponse buildResponse(HttpCode httpCode){
		return buildResponse(httpCode, null);
	}

	public static BaseResponse buildResponse(HttpCode httpCode, Object data){
		return new BaseResponse(httpCode.value(), httpCode.message(), System.currentTimeMillis(), data);
	}

}
