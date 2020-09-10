package com.mm.auth.service.model;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class Menu implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = 9166100489761755366L;

	private long id;
	private String code;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getAuthority() {
		return this.code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
