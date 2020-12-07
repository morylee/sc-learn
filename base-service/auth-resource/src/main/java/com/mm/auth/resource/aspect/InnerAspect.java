package com.mm.auth.resource.aspect;

import com.mm.support.BaseResponse;
import com.mm.support.HttpCode;
import com.mm.support.Inner;
import com.mm.constant.SecurityConstants;
import com.mm.util.ResponseUtil;
import com.mm.util.ServletUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author mory.lee
 */
@Aspect
@Component
public class InnerAspect implements Ordered {

	private final Logger log = LoggerFactory.getLogger(InnerAspect.class);

	@Around("@annotation(inner)")
	public Object around(ProceedingJoinPoint point, Inner inner) throws Throwable {
		String header = ServletUtil.getRequest().getHeader(SecurityConstants.REQ_ROLE);
		if (inner.value() && !StringUtils.equals(SecurityConstants.REQ_ROLE_INNER, header)){
			log.warn("访问接口 {} 没有权限", point.getSignature().getName());
			BaseResponse baseResponse = ResponseUtil.buildResponse(HttpCode.FORBIDDEN);
			return ResponseEntity.ok(baseResponse);
		} else {
			return point.proceed();
		}
	}

	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE + 1;
	}

}
