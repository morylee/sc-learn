package com.mm.mq.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.mm")
public class MqServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqServiceApplication.class, args);
	}

}
