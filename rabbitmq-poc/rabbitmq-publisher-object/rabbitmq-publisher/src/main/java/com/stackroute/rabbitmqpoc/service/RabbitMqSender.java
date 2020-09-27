package com.stackroute.rabbitmqpoc.service;
import com.stackroute.rabbitmqpoc.domain.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    @Autowired
    RabbitTemplate rabbitTemplate;


    @Value("${javainuse.rabbitmq.exchange}")
    String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee company) {
        rabbitTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);
    }
}
