package com.mm.mq.service.hystrix;

import com.mm.mq.service.api.RabbitSysApi;
import org.springframework.stereotype.Component;

@Component
public class RabbitSysFeignHystrix implements RabbitSysApi {

	@Override
	public void sendSysMessage(Object data) {

	}

	@Override
	public void sendEmailMessage(Object data) {

	}

}
