package com.mm.message.service.impl;

import com.mm.message.service.api.MessageApi;
import com.mm.message.service.dao.EmailTemplateMapper;
import com.mm.message.service.dao.MessageMapper;
import com.mm.message.service.dao.MessageTemplateMapper;
import com.mm.message.service.model.EmailTemplate;
import com.mm.message.service.model.Message;
import com.mm.message.service.model.MessageTemplate;
import com.mm.mq.model.MsgModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.mm.mq.model.QueueName.EMAIL_MESSAGE;
import static com.mm.mq.model.QueueName.SYS_MESSAGE;

@Service("messageApi")
public class MessageApiImpl implements MessageApi {

	@Autowired
	private EmailTemplateMapper emailTemplateMapper;

	@Autowired
	private MailApiImpl mailApiImpl;

	@Autowired
	private MessageMapper messageMapper;

	@Autowired
	private MessageTemplateMapper messageTemplateMapper;

	@Override
	@RabbitListener(queues = SYS_MESSAGE)
	public void sendSysMessage(MsgModel msgModel) {
		MessageTemplate msgTemp = new MessageTemplate(msgModel.getMsgType().getName());
		msgTemp = messageTemplateMapper.load(msgTemp);

		Message message = new Message();
		message.setTitle(msgModel.getTitle());
		message.setContent(formatContent(msgTemp.getContent(), msgModel.getExtData()));
		message.setMsgType(msgModel.getMsgType().getName());
		message.setSenderUuid(msgModel.getFromUuid());
		message.setSender(msgModel.getFrom());
		message.setReceiverUuid(msgModel.getToUuid());
		message.setReceiver(msgModel.getTo());
		message.preInsert();
		messageMapper.save(message);
	}

	@Override
	@RabbitListener(queues = EMAIL_MESSAGE)
	public void sendEmail(MsgModel msgModel) {
		EmailTemplate emailTemp = new EmailTemplate(msgModel.getMsgType().getName());
		emailTemp = emailTemplateMapper.load(emailTemp);
		mailApiImpl.sendTemplateMail(msgModel.getFrom(), msgModel.getTo(), msgModel.getTitle(), formatContent(emailTemp.getContent(), msgModel.getExtData()));
	}

	private String formatContent(String content, Map<String, String> extData) {
		if (extData != null && !extData.isEmpty()) {
			for (Map.Entry<String, String> entry : extData.entrySet()) {
				content = content.replace("{" + entry.getKey() + "}", entry.getValue());
			}
		}

		return content;
	}

}
