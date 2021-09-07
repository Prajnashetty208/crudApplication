package com.springboot.crudapplication.control;

import com.springboot.crudapplication.model.Personal;
import com.springboot.crudapplication.rabbitmq.service.Consumer;
import com.springboot.crudapplication.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/details/")
public class RabbitMQController {

    @Autowired
    public Consumer service;

//    @GetMapping(value = "/consume", consumes = "application/json")
//    public ResponseEntity<Personal> savePersonal(){
//        return new ResponseEntity<Personal>(service.consume(), HttpStatus.OK);
//    }
}
