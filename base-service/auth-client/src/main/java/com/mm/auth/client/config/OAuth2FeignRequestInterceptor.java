package com.mm.auth.client.config;

import com.mm.constant.SecurityConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.util.Assert;

/**
 * @author mory.lee
 */
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {

	private static final String BEARER_TOKEN_TYPE = "bearer";

	private final OAuth2RestTemplate oAuth2RestTemplate;

	OAuth2FeignRequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
		Assert.notNull(oAuth2RestTemplate, "OAuth2RestTemplate can not be null");
		this.oAuth2RestTemplate = oAuth2RestTemplate;
	}

	@Override
	public void apply(RequestTemplate template) {
		template.header(HttpHeaders.AUTHORIZATION, String.format("%s %s", BEARER_TOKEN_TYPE, oAuth2RestTemplate.getAccessToken().toString()));
		template.header(SecurityConstants.REQ_ROLE, SecurityConstants.REQ_ROLE_INNER);
		template.header(SecurityConstants.FROM, SecurityConstants.FROM_GATEWAY);
	}

}
