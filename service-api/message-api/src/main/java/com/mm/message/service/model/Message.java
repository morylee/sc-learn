package com.mm.message.service.model;

import com.mm.model.DataModel;

public class Message extends DataModel<Message> {

	private static final long serialVersionUID = 8699970225591155541L;

	private String title;
	private String content;
	private String msgType;
	private String senderUuid;
	private String sender;
	private String receiverUuid;
	private String receiver;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getSenderUuid() {
		return senderUuid;
	}

	public void setSenderUuid(String senderUuid) {
		this.senderUuid = senderUuid;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiverUuid() {
		return receiverUuid;
	}

	public void setReceiverUuid(String receiverUuid) {
		this.receiverUuid = receiverUuid;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

}
