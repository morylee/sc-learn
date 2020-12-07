package com.mm.auth.service.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class OauthDataSourceConfig {

	@Value("${spring.datasource.oauth.url}")
	private String url;

	@Value("${spring.datasource.oauth.username}")
	private String username;

	@Value("${spring.datasource.oauth.password}")
	private String password;

	@Value("${spring.datasource.oauth.driver-class-name}")
	private String driverClassName;

	@Bean(name = "oauthDataSource")
	public DataSource oauthDataSource() {
		DruidDataSource dataSource = new DruidDataSource();

		dataSource.setUrl(this.url);
		dataSource.setUsername(this.username);
		dataSource.setPassword(this.password);
		dataSource.setDriverClassName(this.driverClassName);

		return dataSource;
	}

}
