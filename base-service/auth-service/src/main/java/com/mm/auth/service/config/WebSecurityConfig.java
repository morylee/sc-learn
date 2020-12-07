package com.mm.auth.service.config;

import com.mm.auth.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Base64Utils;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userServiceDetail;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceDetail).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// 直接使用它默认的manager
		AuthenticationManager manager = super.authenticationManagerBean();
		return manager;
	}

	/**
	 * 采用bcrypt对密码进行编码,也可以new 一个MD5加密, 看需要
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		PasswordEncoder pe = new BCryptPasswordEncoder();
		String ep = pe.encode("123456q!");
		System.out.println(ep);
		System.out.println(pe.matches("123456q!", "$2a$10$v9S69GTMwpztPDLtcKbYSu3tYQXxP4oTJPAq.LYD5AZxW2p1LDvYG"));

		System.out.println(">>>>>>>>>");
		ep = pe.encode("master123.0");
		System.out.println(pe.matches("master123.0", "$2a$10$2Kv/uQ.o4zY/wiDbrB0tDuNPVN.uWNqfC6OO.z9nNmy7Rqt6CQRzS"));
		System.out.println(ep);
		String string = "master:master123.0";
		//将串进行base64编码
		byte[] encode = Base64Utils.encode(string.getBytes());
		System.out.println("Basic " + new String(encode));
	}

}
