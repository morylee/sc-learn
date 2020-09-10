package com.mm.mq.service.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/message")
public interface RabbitSysApi {

	@PostMapping("/system")
	void sendSysMessage(Object data);

	@PostMapping("/email")
	void sendEmailMessage(Object data);

}
