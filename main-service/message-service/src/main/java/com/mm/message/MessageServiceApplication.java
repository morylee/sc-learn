package com.mm.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author mory.lee
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.mm")
@MapperScan("com.mm.message.dao")
public class MessageServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MessageServiceApplication.class, args);
	}
}
