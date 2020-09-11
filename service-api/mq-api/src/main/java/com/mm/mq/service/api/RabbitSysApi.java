package com.mm.mq.service.api;

import com.mm.auth.center.config.OAuth2FeignAutoConfiguration;
import com.mm.mq.service.hystrix.RabbitSysFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "mm-message-provider", configuration = OAuth2FeignAutoConfiguration.class, fallback = RabbitSysFeignHystrix.class)
@RequestMapping("/message")
public interface RabbitSysApi {

	@PostMapping("/system")
	void sendSysMessage(Object data);

	@PostMapping("/email")
	void sendEmailMessage(Object data);

}
