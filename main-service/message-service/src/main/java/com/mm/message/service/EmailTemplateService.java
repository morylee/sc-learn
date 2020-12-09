package com.mm.message.service;

import com.mm.base.impl.BaseApiImpl;
import com.mm.message.api.EmailTemplateApi;
import com.mm.message.dao.EmailTemplateMapper;
import com.mm.message.model.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mory.lee
 */
@Service
public class EmailTemplateService extends BaseApiImpl<EmailTemplate, EmailTemplateMapper> implements EmailTemplateApi {

	@Autowired
	public void setMapper(EmailTemplateMapper mapper) {
		this.mapper = mapper;
	}

}
