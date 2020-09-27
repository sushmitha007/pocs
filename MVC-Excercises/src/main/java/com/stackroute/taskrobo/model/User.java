package com.stackroute.taskrobo.model;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String firstName;
    private String password;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
