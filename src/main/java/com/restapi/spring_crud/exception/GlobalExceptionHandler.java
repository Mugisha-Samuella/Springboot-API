package com.restapi.spring_crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler{
    public GlobalExceptionHandler(String message){
        super(message);
    }
}
