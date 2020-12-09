package com.mm.auth.resource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

/**
 * @author mory.lee
 */
@ConfigurationProperties(prefix = "security.oauth2.resource")
public class Oauth2ResourceServerProperties {

	private String id;
	private String userInfoUri;
	private String permitReqs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserInfoUri() {
		return userInfoUri;
	}

	public void setUserInfoUri(String userInfoUri) {
		this.userInfoUri = userInfoUri;
	}

	public String getPermitReqs() {
		return permitReqs;
	}

	public void setPermitReqs(String permitReqs) {
		this.permitReqs = permitReqs;
	}

	public String[] getPermitRequests() {
		if (this.permitReqs != null) {
			return this.permitReqs.split(",");
		}
		return new String[]{};
	}

}
