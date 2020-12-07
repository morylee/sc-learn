package com.mm.support;

/**
 * @author mory.lee
 */
public class BaseResponse<T> {

	private Integer status;
	private String message;
	private Long timestamp;
	private T data;

	public BaseResponse() {

	}

	public BaseResponse(Integer status, String message, Long timestamp, T data) {
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
