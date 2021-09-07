package com.springboot.crudapplication.rabbitmq.service;

import com.springboot.crudapplication.exception.RabbitMQException;
import com.springboot.crudapplication.rabbitmq.model.RabbitMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Value("${rabbit.exchangeName}")
    private String exchangeName;

    @Value("${rabbit.routingKey}")
    private String routingKey;

    @Autowired
    private RabbitTemplate template;

    public boolean sendToQueue(RabbitMessage msg){
        try{
            template.convertAndSend(exchangeName,routingKey,msg);
            return true;
        } catch (Exception e){
            throw new RabbitMQException("Error posting to queue"+e);
        }
    }
}
