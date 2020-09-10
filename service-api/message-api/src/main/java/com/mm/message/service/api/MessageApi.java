package com.mm.message.service.api;

import com.mm.mq.model.MsgModel;

public interface MessageApi {

	void sendSysMessage(MsgModel msgModel);

	void sendEmail(MsgModel msgModel);

}
