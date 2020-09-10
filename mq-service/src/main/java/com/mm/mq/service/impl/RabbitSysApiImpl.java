package com.mm.mq.service.impl;

import com.mm.mq.model.MsgModel;
import com.mm.mq.model.MsgType;
import com.mm.mq.service.api.RabbitSysApi;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.mm.mq.model.QueueName.*;

@RestController
public class RabbitSysApiImpl implements RabbitSysApi {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void sendSysMessage(Object data) {
		rabbitTemplate.convertAndSend(EXCHANGE_SYS, SYS_MESSAGE, data);
	}

	@Override
	public void sendEmailMessage(Object data) {
		rabbitTemplate.convertAndSend(EXCHANGE_EMAIL, EMAIL_MESSAGE, data);
	}

}
