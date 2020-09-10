package com.mm.message.service.api;

public interface MailApi {

	void sendSimpleMail(String from, String to, String subject, String content);

	void sendTemplateMail(String from, String to, String subject, String content);

	void sendAttachmentMail(String from, String to, String subject, String content, String filePath);

	void sendInlineResourceMail(String from, String to, String subject, String content, String imgPath, String imgId);

}
