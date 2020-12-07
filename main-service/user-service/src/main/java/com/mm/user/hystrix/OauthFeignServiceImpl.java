package com.mm.user.hystrix;

import com.mm.user.feign.OauthFeignService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author mory.lee
 */
@Component
public class OauthFeignServiceImpl implements OauthFeignService {

	@Override
	public OAuth2AccessToken oauthToken(Map<String, String> parameters) {
		return null;
	}

}
