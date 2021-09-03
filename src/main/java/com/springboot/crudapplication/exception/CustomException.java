package com.springboot.crudapplication.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomException {
    String reason;
    HttpStatus statusCode;
    String exception;

    public CustomException(String reason, HttpStatus statusCode, String exception) {
        this.reason = reason;
        this.statusCode = statusCode;
        this.exception = exception;
    }
}
