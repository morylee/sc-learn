package com.mm.mq.service;

import com.alibaba.fastjson.JSONObject;
import com.mm.mq.model.MsgModel;
import com.mm.mq.api.RabbitSysApi;
import com.mm.util.GeneratorUtil;
import com.mm.util.Map2ModelUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.mm.mq.model.QueueName.*;

/**
 * @author mory.lee
 */
@Service
public class RabbitSysService implements RabbitSysApi {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void sendSysMessage(Map<String, Object> params) {
		MsgModel msgModel = getExtData(params);
		rabbitTemplate.convertAndSend(EXCHANGE_SYS, SYS_MESSAGE, msgModel);
	}

	@Override
	public void sendEmailMessage(Map<String, Object> params) {
		MsgModel msgModel = getExtData(params);
		rabbitTemplate.convertAndSend(EXCHANGE_EMAIL, EMAIL_MESSAGE, msgModel);
	}

	private MsgModel getExtData(Map<String, Object> params) {
		JSONObject json = new JSONObject(params);
		Map<String, Object> extData = new HashMap<>();
		if (json.containsKey("extData")) {
			if (!json.containsKey("data")) {
				extData = json.getJSONObject("extData").getInnerMap();
			}
			params.remove("extData");
		}
		if (json.containsKey("data")) {
			extData = json.getJSONObject("data").getInnerMap();
		}
		MsgModel msgModel = Map2ModelUtil.convert(MsgModel.class, params);
		msgModel.setExtData(extData);

		return msgModel;
	}

}
