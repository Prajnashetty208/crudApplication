package com.springboot.crudapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonalDetailsNotFoundException extends RuntimeException{

    public PersonalDetailsNotFoundException(String exception){
        super(exception);
    }
}
