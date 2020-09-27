package com.stackroute.rabbitmqlistner;

import com.stackroute.rabbitmqlistner.domain.SimpleMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqListnerApplication {
	private SimpleMessage simpleMessage;
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqListnerApplication.class, args);
	}


}
