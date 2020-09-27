package com.stackroute.rabbitmqlistner.listener;

import com.stackroute.rabbitmqlistner.domain.SimpleMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;


public class RabbitMQMessageListener implements MessageListener {
    SimpleMessage simpleMessage;
    @Override
    public void onMessage(Message message) {
        System.out.println("message");
        System.out.println(" message=["+new String(message.getBody())+"] ");

    }

}
