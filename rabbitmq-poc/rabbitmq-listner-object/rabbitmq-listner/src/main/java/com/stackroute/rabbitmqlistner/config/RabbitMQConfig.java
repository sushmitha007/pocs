package com.stackroute.rabbitmqlistner.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
//defining queue
    private static final String MY_QUEUE ="javaqueue";
    //creating queue
    @Bean
    Queue JavaInUseQueue(){
        return new Queue(MY_QUEUE,true);
    }
    //Creating an Exchange
    @Bean
    Exchange myExchange(){
        return ExchangeBuilder.topicExchange("javaexchange").durable(true).build();
    }
    //Binding Queue and Exchanges
    @Bean
    Binding binding(){
        //this is the traditional way of binding
//        return new Binding(MY_QUEUE, Binding.DestinationType.QUEUE,"myTopicExchange","topic",null);
        //more declarative way of binding
        return BindingBuilder
                .bind(JavaInUseQueue())
                .to(myExchange())
                .with("javaroutingkey")
                .noargs();
    }
    //Creating connections to rabbitMq broker
    @Bean
    ConnectionFactory connectionFactory(){
        //we want connection to be stable,so that we needn't close or open connection
        CachingConnectionFactory cachingConnectionFactory =new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
