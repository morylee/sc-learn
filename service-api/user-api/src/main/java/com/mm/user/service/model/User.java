package com.mm.user.service.model;

import com.mm.model.DataModel;

public class User extends DataModel<User> {

	private static final long serialVersionUID = 1402187524118045557L;
	private String name;
	private String nickname;
	private String logoPath;
	private String password;

	public User() {

	}

	public User(String uuid, String name) {
		this.uuid = uuid;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
