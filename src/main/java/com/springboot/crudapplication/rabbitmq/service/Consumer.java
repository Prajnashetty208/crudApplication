package com.springboot.crudapplication.rabbitmq.service;

import com.springboot.crudapplication.model.Personal;
import com.springboot.crudapplication.rabbitmq.model.RabbitMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Consumer {
    @Value("${rabbit.queueName}")
    private String queueName;

    @RabbitListener(queues = "message_queue")
    public void consume(RabbitMessage msg){
        System.out.println("msg"+msg);
    }
}
