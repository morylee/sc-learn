package com.mm.user.hystrix;

import com.mm.support.BaseResponse;
import com.mm.user.feign.MessageFeignService;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author mory.lee
 */
@Component
public class MessageFeignServiceImpl implements MessageFeignService {

	@Override
	public BaseResponse sendEmailMessage(Map<String, Object> params) {
		return null;
	}

	@Override
	public BaseResponse sendSysMessage(Map<String, Object> params) {
		return null;
	}

}
