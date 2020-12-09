package com.mm.gateway.fallbacks;

import com.mm.base.controller.BaseController;
import com.mm.base.support.HttpCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mory.lee
 */
@RestController
@RequestMapping("/gateway")
public class ServiceFallbackController extends BaseController {

	/**
	 * @return
	 */
	@RequestMapping("/fallback")
	public Object fallback() {
		return setModelMap(HttpCode.INTERNAL_SERVER_ERROR);
	}

}
