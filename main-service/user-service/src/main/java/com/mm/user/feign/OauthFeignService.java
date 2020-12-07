package com.mm.user.feign;

import com.mm.user.hystrix.OauthFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author mory.lee
 */
@Service
@FeignClient(value = "auth-service", fallback = OauthFeignServiceImpl.class)
public interface OauthFeignService {

	@PostMapping(value = "/oauth/token")
	OAuth2AccessToken oauthToken(@RequestParam Map<String, String> parameters);

}
