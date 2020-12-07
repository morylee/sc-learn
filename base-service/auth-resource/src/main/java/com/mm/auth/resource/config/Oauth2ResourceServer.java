package com.mm.auth.resource.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Order(3)
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(Oauth2ResourceServerProperties.class)
public class Oauth2ResourceServer extends ResourceServerConfigurerAdapter {

	private final Oauth2ResourceServerProperties resourceServer;

	private final PermitAllUrlProperties permitAllUrl;

	@Autowired
	public Oauth2ResourceServer(Oauth2ResourceServerProperties resourceServer, PermitAllUrlProperties permitAllUrl) {
		this.resourceServer = resourceServer;
		this.permitAllUrl = permitAllUrl;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		if (StringUtils.isNotBlank(resourceServer.getId())) {
			resources.resourceId(resourceServer.getId()).stateless(true);
		}
		//...... 还可以有有其他的配置
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling()
				.authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED));

		// 允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
		http.headers().frameOptions().disable();
		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
		// 将上面获取到的请求，暴露出来
		permitAllUrl.getUrls().forEach(url -> registry.antMatchers(url).permitAll());
		for (String permitUrl: resourceServer.getPermitRequests()) {
			http.authorizeRequests().antMatchers(permitUrl.trim()).permitAll();
		}
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

}
