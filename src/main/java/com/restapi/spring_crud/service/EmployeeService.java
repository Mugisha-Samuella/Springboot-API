package com.restapi.spring_crud.service;

import com.restapi.spring_crud.exception.GlobalExceptionHandler;
import com.restapi.spring_crud.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.restapi.spring_crud.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id){
        return employeeRepository.findById(id)
                .orElseThrow(()-> new Reso("Employee with id " + id + " not found!"));
    }

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



    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee employeeUpdate = employeeRepository.findById(id)
                .orElseThrow(()-> new GlobalExceptionHandler("Employee with id " + id + " not found!"));

        employeeUpdate.setFirstName(employeeDetails.getFirstName());
        employeeUpdate.setLastName(employeeDetails.getLastName());
        employeeUpdate.setEmail(employeeDetails.getEmail());
        employeeUpdate.setPhotoUrl(employeeDetails.getPhotoUrl());
        employeeUpdate.setEmployeeDepartment(employeeDetails.getEmployeeDepartment());
        employeeUpdate.setStatus(employeeDetails.getStatus());
        employeeUpdate.setEmployeeTitle(employeeDetails.getEmployeeTitle());

        employeeRepository.save(employeeUpdate);
        return ResponseEntity.ok(employeeUpdate);
    }

    public ResponseEntity<HttpStatus> deleteEmployeeByID(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new GlobalExceptionHandler("Employee with id " + id + " not found!"));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
