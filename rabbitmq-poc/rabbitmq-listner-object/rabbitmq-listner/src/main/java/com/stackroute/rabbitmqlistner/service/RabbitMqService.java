package com.stackroute.rabbitmqlistner.service;

import com.stackroute.rabbitmqlistner.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqService implements RabbitListenerConfigurer {

    @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
    public void recievedMessage(Employee employee) {

        System.out.println("Recieved Message From RabbitMQ:" +employee.toString());
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
