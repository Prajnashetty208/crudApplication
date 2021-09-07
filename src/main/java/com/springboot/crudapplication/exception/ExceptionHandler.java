package com.springboot.crudapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleException(OrderNotFoundException e){
        CustomResponse ex = new CustomResponse("Order not found", HttpStatus.NOT_FOUND,e.getMessage());
        return new ResponseEntity<Object>(ex,HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PersonalDetailsNotFoundException.class)
    public ResponseEntity<Object> handlePersonalDetailsNotFoundException(PersonalDetailsNotFoundException e){
        CustomResponse ex = new CustomResponse("Details not found", HttpStatus.NOT_FOUND,e.getMessage());
        return new ResponseEntity<Object>(ex,HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RabbitMQException.class)
    public ResponseEntity<Object> handleRMQException(RabbitMQException e){
        CustomResponse ex = new CustomResponse("Details not found", HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return new ResponseEntity<Object>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
