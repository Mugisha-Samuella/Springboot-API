package com.restapi.spring_crud.controller;

import com.restapi.spring_crud.exception.EmployeeNotFoundException;
import com.restapi.spring_crud.model.Employee;
import com.restapi.spring_crud.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) throws BadRequestException {
        if(employee == null){
            throw new BadRequestException("Invalid Employee data");
        }
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully!");

    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);

        if (employeeOptional.isPresent()){
            return ResponseEntity.ok(employeeOptional.get());
        }else{
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }

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
