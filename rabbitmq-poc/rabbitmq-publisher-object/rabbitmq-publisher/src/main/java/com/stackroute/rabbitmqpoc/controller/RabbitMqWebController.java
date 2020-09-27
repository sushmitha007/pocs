package com.stackroute.rabbitmqpoc.controller;
import com.stackroute.rabbitmqpoc.domain.Employee;
import com.stackroute.rabbitmqpoc.service.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMqWebController {


    @Autowired
    RabbitMqSender rabbitMqSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {

        Employee emp=new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        rabbitMqSender.send(emp);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

}
