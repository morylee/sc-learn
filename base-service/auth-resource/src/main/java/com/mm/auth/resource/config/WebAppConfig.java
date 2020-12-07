package com.mm.auth.resource.config;

import com.mm.auth.resource.interceptor.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mory.lee
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

	@Autowired
	private GlobalInterceptor globalInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 自定义拦截器，添加拦截路径和排除拦截路径
		registry.addInterceptor(globalInterceptor).addPathPatterns("/**");
	}

}
