package com.restapi.spring_crud.service;

import com.restapi.spring_crud.api.model.Employee;
import com.restapi.spring_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){

    }
}
