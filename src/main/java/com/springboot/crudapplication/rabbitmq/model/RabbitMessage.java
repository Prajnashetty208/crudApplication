package com.springboot.crudapplication.rabbitmq.model;

import com.springboot.crudapplication.model.Personal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMessage {

    private String message;
    private Personal body;
}
