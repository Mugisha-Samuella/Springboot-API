package com.restapi.spring_crud.exception;

public class EmployeeNotFoundException extends  RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
