package com.springboot.crudapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleException(OrderNotFoundException e){
        CustomException ex = new CustomException("Order not found", HttpStatus.NOT_FOUND,e.getMessage());
        return new ResponseEntity<Object>(ex,HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PersonalDetailsNotFoundException.class)
    public ResponseEntity<Object> handlePersonalDetailsNotFoundException(PersonalDetailsNotFoundException e){
        CustomException ex = new CustomException("Details not found", HttpStatus.NOT_FOUND,e.getMessage());
        return new ResponseEntity<Object>(ex,HttpStatus.NOT_FOUND);
    }
}
