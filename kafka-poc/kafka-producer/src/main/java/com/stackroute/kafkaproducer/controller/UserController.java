package com.stackroute.kafkaproducer.controller;


import com.stackroute.kafkaproducer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserController {
    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;
    private final static String TOPIC="Kafka_Example";
    @GetMapping("publish/{name}")
    public String post(@PathVariable("name") final String name){
        kafkaTemplate.send(TOPIC,new User(name,123l));
        return "published successfully";
    }
}
