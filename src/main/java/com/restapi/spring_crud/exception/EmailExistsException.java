package com.restapi.spring_crud.exception;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException(){
        super("Email already exists!!");
    }
}
