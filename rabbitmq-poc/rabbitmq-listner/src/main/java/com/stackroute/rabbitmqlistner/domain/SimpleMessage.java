package com.stackroute.rabbitmqlistner.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class SimpleMessage implements Serializable {
    private String name;
    private String description;

    public SimpleMessage() {
    }

    public SimpleMessage(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
