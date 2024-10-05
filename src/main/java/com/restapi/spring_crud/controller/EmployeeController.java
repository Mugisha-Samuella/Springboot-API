package com.restapi.spring_crud.controller;

import com.restapi.spring_crud.exception.EmployeeNotFoundException;
import com.restapi.spring_crud.model.Employee;
import com.restapi.spring_crud.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("Hello from frontend.");
        return "Samuella";
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) throws Exception {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null){
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        return ResponseEntity.ok(employee);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails).getBody();
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployeeByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
