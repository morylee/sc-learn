package com.mm.message.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author mory.lee
 */
@Service
public class MailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender mailSender;

	/**
	 * 发送文本邮件
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 */
	public void sendSimpleMail(String from, String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		try {
			mailSender.send(message);
			logger.info("send simple mail success");
		} catch (Exception e) {
			logger.error("send simple mail error: ", e);
		}
	}

	/**
	 * 发送文本邮件
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 */
	public void sendTemplateMail(String from, String to, String subject, String content) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			mailSender.send(message);
			logger.info("send template mail success");
		} catch (Exception e) {
			logger.error("send template mail error: ", e);
		}
	}

	/**
	 * 发送附件
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 * @param filePath
	 */
	public void sendAttachmentMail(String from, String to, String subject, String content, String filePath) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			FileSystemResource file = new FileSystemResource(new File(filePath));
			String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
			helper.addAttachment(fileName, file);
			mailSender.send(message);
			logger.info("send mail with attachment success");
		} catch (Exception e) {
			logger.error("send mail with attachment error: ", e);
		}
	}

	/**
	 * 发送内嵌图片
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 * @param imgPath
	 * @param imgId
	 */
	public void sendInlineResourceMail(String from, String to, String subject, String content, String imgPath, String imgId) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			FileSystemResource img = new FileSystemResource(new File(imgPath));
			helper.addInline(imgId, img);
			mailSender.send(message);
			logger.info("send mail with resources success");
		} catch (Exception e) {
			logger.error("send mail with resources error: ", e);
		}
	}

}
