package com.stackroute.rabbitmqpoc;

import com.stackroute.rabbitmqpoc.domain.SimpleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqPocApplication implements CommandLineRunner {
	private RabbitTemplate rabbitTemplate;
	private SimpleMessage simpleMessage;

	@Autowired
	public RabbitmqPocApplication(RabbitTemplate rabbitTemplate, SimpleMessage simpleMessage) {
		this.rabbitTemplate = rabbitTemplate;
		this.simpleMessage = simpleMessage;
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqPocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 this.simpleMessage.setName("First Message");
		 this.simpleMessage.setDescription("simpleDescription");
		rabbitTemplate.convertAndSend("myTopicExchange","topic", simpleMessage);
}}
