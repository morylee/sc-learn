package com.mm.auth.resource.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.mm.base.support.HttpCode;
import com.mm.base.constant.SecurityConstants;
import com.mm.base.util.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mory.lee
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {

	private final Logger log = LoggerFactory.getLogger(GlobalInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String secretKey = request.getHeader(SecurityConstants.FROM);
		log.info("Request from: {}", secretKey);
		if (!StringUtils.equals(SecurityConstants.FROM_GATEWAY, secretKey)) {
			log.warn("访问接口 {} 没有权限", request.getRequestURI());
			response.setContentType("application/json; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.write(JSONObject.toJSONString(ResponseUtil.buildResponse(HttpCode.FORBIDDEN)));
			return false;
		}
		return true;
	}

}
