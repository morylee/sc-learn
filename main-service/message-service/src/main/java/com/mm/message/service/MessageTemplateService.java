package com.mm.message.service;

import com.mm.base.impl.BaseApiImpl;
import com.mm.message.api.MessageTemplateApi;
import com.mm.message.dao.MessageTemplateMapper;
import com.mm.message.model.MessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mory.lee
 */
@Service
public class MessageTemplateService extends BaseApiImpl<MessageTemplate, MessageTemplateMapper> implements MessageTemplateApi {

	@Autowired
	public void setMapper(MessageTemplateMapper mapper) {
		this.mapper = mapper;
	}

}
