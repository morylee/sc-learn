package com.mm.mq.controller;

import com.mm.base.controller.BaseController;
import com.mm.mq.service.RabbitSysService;
import com.mm.base.support.Inner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author mory.lee
 */
@RestController
@RequestMapping("/message")
public class MessageController extends BaseController {

	@Autowired
	private RabbitSysService sysMqService;

	/**
	 * @param params
	 * @return
	 */
	@Inner
	@PostMapping("/system")
	public Object sendSysMessage(@RequestBody Map<String, Object> params) {
		sysMqService.sendSysMessage(params);

		return setSuccessModelMap(true);
	}

	/**
	 * @param params
	 * @return
	 */
	@PostMapping("/email")
	public Object sendEmailMessage(@RequestBody Map<String, Object> params) {
		sysMqService.sendEmailMessage(params);

		return setSuccessModelMap(true);
	}

}
