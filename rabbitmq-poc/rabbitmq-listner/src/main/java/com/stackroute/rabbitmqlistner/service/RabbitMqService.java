package com.stackroute.rabbitmqlistner.service;

import com.stackroute.rabbitmqlistner.domain.SimpleMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqService {

    @RabbitListener(queues = "MyQueue")
    public void recieveMsg(SimpleMessage simpleMessage){
        System.out.println("recieved msg"+simpleMessage);
    }
}
