package com.mm.mq.config;

import com.mm.mq.model.QueueName;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean
	public Queue sysMessage() {
		return new Queue(QueueName.SYS_MESSAGE);
	}

	@Bean
	public TopicExchange exchangeSys() {
		return new TopicExchange(QueueName.EXCHANGE_SYS);
	}

	@Bean
	public Binding bindingSysMessage(Queue sysMessage, TopicExchange exchangeSys) {
		return BindingBuilder.bind(sysMessage).to(exchangeSys).with(QueueName.SYS_MESSAGE);
	}

	@Bean
	public Queue emailMessage() {
		return new Queue((QueueName.EMAIL_MESSAGE));
	}

	@Bean
	public TopicExchange exchangeEmail() {
		return new TopicExchange(QueueName.EXCHANGE_EMAIL);
	}

	@Bean
	public Binding bindingEmailMessage(Queue emailMessage, TopicExchange exchangeEmail) {
		return BindingBuilder.bind(emailMessage).to(exchangeEmail).with(QueueName.EMAIL_MESSAGE);
	}

}
