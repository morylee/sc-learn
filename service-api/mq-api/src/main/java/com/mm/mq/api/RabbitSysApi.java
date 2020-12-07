package com.mm.mq.api;

import java.util.Map;

/**
 * @author mory.lee
 */
public interface RabbitSysApi {

	/**
	 * 发送系统消息
	 * @param params
	 */
	void sendSysMessage(Map<String, Object> params);

	/**
	 * 发送邮件消息
	 * @param params
	 */
	void sendEmailMessage(Map<String, Object> params);

}
