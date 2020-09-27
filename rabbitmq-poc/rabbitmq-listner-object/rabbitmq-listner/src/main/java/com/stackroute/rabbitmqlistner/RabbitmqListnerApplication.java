package com.stackroute.rabbitmqlistner;

import com.stackroute.rabbitmqlistner.domain.Employee;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RabbitmqListnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqListnerApplication.class, args);
	}


}
