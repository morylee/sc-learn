package com.mm.model;

public enum State {

	/**
	 * 可用
	 */
	Enable(0, "启用"),
	/**
	 * 不可用
	 */
	Disabled(1, "禁用");

	private int code;
	private String name;

	State(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

}
