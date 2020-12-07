package com.mm.user.feign;

import com.mm.support.BaseResponse;
import com.mm.user.hystrix.MessageFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author mory.lee
 */
@Service
@FeignClient(name = "mq-service", fallback = MessageFeignServiceImpl.class)
public interface MessageFeignService {

	/**
	 * 邮件接口
	 * @param params
	 */
	@PostMapping("/message/email")
	BaseResponse sendEmailMessage(@RequestBody Map<String, Object> params);

	/**
	 * 系统消息接口
	 * @param params
	 */
	@PostMapping("/message/system")
	BaseResponse sendSysMessage(@RequestBody Map<String, Object> params);

}
