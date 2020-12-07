package com.mm.support;

import com.mm.config.Resources;

/**
 * @author mory.lee
 */

public enum HttpCode {

	/** 200请求成功 */
	OK(200),
	/** 207频繁操作 */
	MULTI_STATUS(207),
	/** 302已经存在*/
	ALREADY_EXIST(302),
	/** 303登录失败 */
	LOGIN_FAIL(303),
	/** 400请求参数出错 */
	BAD_REQUEST(400),
	/** 401没有登录 */
	UNAUTHORIZED(401),
	/** 403没有权限 */
	FORBIDDEN(403),
	/** 404找不到页面 */
	NOT_FOUND(404),
	/** 408请求超时 */
	REQUEST_TIMEOUT(408),
	/** 409发生冲突 */
	CONFLICT(409),
	/** 410已被删除 */
	GONE(410),
	/** 417执行失败*/
	FAILED(417),
	/** 500服务器出错 */
	INTERNAL_SERVER_ERROR(500),
	/** 请求超时 */
	TIMEOUT_ERROR(504);

	private final Integer value;

	private HttpCode(Integer value) {
		this.value = value;
	}

	/**
	 * Return the integer value of this status code.
	 */
	public Integer value() {
		return this.value;
	}

	public String message() {
		return Resources.getMessage("HTTPCODE_" + this.value);
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	public static HttpCode valueOf(Integer value) {
		if (value != null) {
			for (HttpCode httpCode : values()) {
				if (httpCode.value.intValue() == value.intValue()) {
					return httpCode;
				}
			}
		}
		return null;
	}

	public boolean is(HttpCode httpCode) {
		return  httpCode != null && httpCode.value.intValue() == this.value.intValue();
	}

	public boolean is(Integer value) {
		return value != null && value.intValue() == this.value.intValue();
	}

}
