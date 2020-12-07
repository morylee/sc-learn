package com.mm.auth.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

//@Configuration
//@Order(1)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
				.loginProcessingUrl("/form/login")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.and()
				.anonymous()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "**").permitAll();
	}

}
