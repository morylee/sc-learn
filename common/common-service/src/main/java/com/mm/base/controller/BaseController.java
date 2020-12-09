package com.mm.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mm.base.constant.Constants;
import com.mm.base.support.BaseResponse;
import com.mm.base.support.HttpCode;
import com.mm.base.exception.BaseException;
import com.mm.base.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mory.lee
 */
@ControllerAdvice
public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

	/** 设置成功响应代码 */
	protected ResponseEntity<BaseResponse> setSuccessModelMap() {
		return setSuccessModelMap(null);
	}

	/** 设置成功响应代码 */
	protected ResponseEntity<BaseResponse> setSuccessModelMap(Object data) {
		return setModelMap(HttpCode.OK, data);
	}

	/** 设置响应代码 */
	protected ResponseEntity<BaseResponse> setModelMap(HttpCode httpCode) {
		return setModelMap(httpCode, null);
	}

	/** 设置响应代码 */
	protected ResponseEntity<BaseResponse> setModelMap(HttpCode httpCode, Object data) {
		BaseResponse baseResponse = ResponseUtil.buildResponse(httpCode, data);
		return ResponseEntity.ok(baseResponse);
	}

	@ExceptionHandler(Exception.class)
	public void restExceptionHandler(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler, Exception ex)
			throws Exception {
		logger.error(Constants.Exception_Head, ex);

		BaseResponse baseResponse;
		if (ex instanceof BaseException) {
			baseResponse = ((BaseException) ex).handler();
		} else {
			baseResponse = ResponseUtil.buildResponse(HttpCode.INTERNAL_SERVER_ERROR);
		}
		response.setContentType("application/json;charset=UTF-8");
		byte[] bytes = JSON.toJSONBytes(baseResponse, SerializerFeature.DisableCircularReferenceDetect);
		response.getOutputStream().write(bytes);
	}

}
