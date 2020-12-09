package com.mm.message.service;

import com.mm.base.impl.BaseApiImpl;
import com.mm.message.api.MessageApi;
import com.mm.message.dao.MessageMapper;
import com.mm.message.model.EmailTemplate;
import com.mm.message.model.Message;
import com.mm.message.model.MessageTemplate;
import com.mm.mq.model.MsgModel;
import com.mm.base.util.TypeParseUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.mm.mq.model.QueueName.EMAIL_MESSAGE;
import static com.mm.mq.model.QueueName.SYS_MESSAGE;

/**
 * @author mory.lee
 */
@Service
public class MessageService extends BaseApiImpl<Message, MessageMapper> implements MessageApi {

	@Autowired
	public void setMapper(MessageMapper mapper) {
		this.mapper = mapper;
	}

	@Autowired
	private EmailTemplateService emailTemplateService;

	@Autowired
	private MailService mailService;

	@Autowired
	private MessageTemplateService messageTemplateService;

	@RabbitListener(queues = SYS_MESSAGE)
	public void sendSysMessage(MsgModel msgModel) {
		MessageTemplate msgTemp = new MessageTemplate(msgModel.getMsgType());
		msgTemp = messageTemplateService.load(msgTemp);

		Message message = new Message();
		message.setTitle(msgModel.getTitle());
		message.setContent(formatContent(msgTemp.getContent(), msgModel.getExtData()));
		message.setMsgType(msgModel.getMsgType());
		message.setSenderUuid(msgModel.getFromUuid());
		message.setSender(msgModel.getFrom());
		message.setReceiverUuid(msgModel.getToUuid());
		message.setReceiver(msgModel.getTo());
		message.preInsert();
		mapper.save(message);
	}

	@RabbitListener(queues = EMAIL_MESSAGE)
	public void sendEmail(MsgModel msgModel) {
		EmailTemplate emailTemp = new EmailTemplate(msgModel.getMsgType());
		emailTemp = emailTemplateService.load(emailTemp);
		mailService.sendTemplateMail(msgModel.getFrom(), msgModel.getTo(), msgModel.getTitle(), formatContent(emailTemp.getContent(), msgModel.getExtData()));
	}

	private String formatContent(String content, Map<String, Object> extData) {
		if (extData != null && !extData.isEmpty()) {
			for (Map.Entry<String, Object> entry : extData.entrySet()) {
				content = content.replace("{" + entry.getKey() + "}", TypeParseUtil.convertToString(entry.getValue()));
			}
		}

		return content;
	}

}
