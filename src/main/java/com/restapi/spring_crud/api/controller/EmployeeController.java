package com.restapi.spring_crud.api.controller;

import com.restapi.spring_crud.api.model.Employee;
import com.restapi.spring_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    public EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping
   public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
   }
}
