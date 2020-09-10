package com.mm.message.service.model;

import com.mm.model.DataModel;

public class MessageTemplate extends DataModel<MessageTemplate> {

	private static final long serialVersionUID = 7631147126442541940L;

	private String msgType;
	private String content;

	public MessageTemplate() {

	}

	public MessageTemplate(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
