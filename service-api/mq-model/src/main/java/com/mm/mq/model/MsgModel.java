package com.mm.mq.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class MsgModel implements Serializable {

	private static final long serialVersionUID = -4944093949992387581L;
	private String fromUuid;
	private String from;
	private String toUuid;
	private String to;
	private MsgType msgType;
	private Date createdAt;
	private String title;
	private String templateUuid;
	private Map<String, String> extData;

	public String getFromUuid() {
		return fromUuid;
	}

	public void setFromUuid(String fromUuid) {
		this.fromUuid = fromUuid;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getToUuid() {
		return toUuid;
	}

	public void setToUuid(String toUuid) {
		this.toUuid = toUuid;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public MsgType getMsgType() {
		return msgType;
	}

	public void setMsgType(MsgType msgType) {
		this.msgType = msgType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTemplateUuid() {
		return templateUuid;
	}

	public void setTemplateUuid(String templateUuid) {
		this.templateUuid = templateUuid;
	}

	public Map<String, String> getExtData() {
		return extData;
	}

	public void setExtData(Map<String, String> extData) {
		this.extData = extData;
	}

}
