package com.restapi.spring_crud.api.controller;

import com.restapi.spring_crud.api.model.Employee;
import com.restapi.spring_crud.exception.ResourceNotFoundException;
import com.restapi.spring_crud.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("Hello from frontend.");
        return "Samuellla";
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee)throws Exception{


        ResponseEntity<String> validationResponse = validateEmployee(employee);
        if(validationResponse != null){
                  return validationResponse;
        }

        Optional<Employee> employeeOptional = employeeRepository.findByEmail(employee.getEmail());
        if(employeeOptional.isPresent()){
            throw new BadRequestException("Employee already exists.");
        }
        employeeRepository.save(employee);

        return ResponseEntity.ok("Employee created successfully!");
    }

    private ResponseEntity<String> validateEmployee(@RequestBody Employee employee){
        List<String> validationMessages = new ArrayList<>();

        if(isNullOrEmpty(employee.getFirstName())){
            validationMessages.add("First name is required! \n");
        }
        if(isNullOrEmpty(employee.getLastName())){
            validationMessages.add("Last name is required! \n");
        }
        if(isNullOrEmpty(employee.getEmployeeTitle())){
            validationMessages.add("Employee Title is required! \n");
        }
        if(isNullOrEmpty(employee.getEmail())){
            validationMessages.add("Email is required! \n");
        }

        if(!validationMessages.isEmpty()){
            return ResponseEntity.ok(String.join(" ", validationMessages));
        }

        return null;
    }

    private boolean isNullOrEmpty(String value){
        return value == null || value.isEmpty() || value.equals("");
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee =employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id " + id + " not found"));
        return ResponseEntity.ok(employee);
    }

    @Transactional
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new  ResourceNotFoundException("Employee with id " + id + " not found"));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmail(employeeDetails.getEmail());
        updateEmployee.setEmployeeTitle(employeeDetails.getEmployeeTitle());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id " + id + " not found"));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
