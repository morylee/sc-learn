package com.mm.auth.center.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.constant.HttpCode;
import com.mm.exception.BusinessException;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;

public class Oauth2FeignErrorInterceptor implements ErrorDecoder {

	Logger logger = LoggerFactory.getLogger(Oauth2FeignErrorInterceptor.class);

	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(final String methodKey, final Response response) {
		if (response.status() >= HttpStatus.BAD_REQUEST.value() && response.status() < HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			return new HystrixBadRequestException("request exception wrapper");
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			HashMap map = mapper.readValue(response.body().asInputStream(), HashMap.class);
			Integer code = (Integer) map.get("httpCode");
			String message = (String) map.get("msg");
			if (code != null) {
				if (HttpCode.BAD_REQUEST.is(code)) {
					throw new IllegalArgumentException(message);
				} else {
					throw new BusinessException(message);
				}
			}
		} catch (IOException e) {
			logger.info("Failed to process response body");
		}
		return defaultErrorDecoder.decode(methodKey, response);
	}

}
