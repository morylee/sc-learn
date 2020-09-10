package com.mm.message.service.model;

import com.mm.model.DataModel;

public class EmailTemplate extends DataModel<EmailTemplate> {

	private static final long serialVersionUID = -9097909210010395056L;

	private String msgType;
	private String content;

	public EmailTemplate() {

	}

	public EmailTemplate(String msgType) {
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
