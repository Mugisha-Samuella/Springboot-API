package com.restapi.spring_crud.service;

import com.restapi.spring_crud.exception.EmailExistsException;
import com.restapi.spring_crud.exception.EmployeeNotFoundException;
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

    public Optional<Employee> getEmployeeById(long id){return employeeRepository.findById(id); }

    public Employee createEmployee(Employee employee){
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(employee.getEmail());
        if(employeeOptional.isPresent()){
            throw new EmailExistsException();
        }
        return employeeRepository.save(employee);
    }

    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Optional<Employee> updateEmployee = employeeRepository.findById(id);

        if(updateEmployee.isPresent()) {
            Employee employeeUpdate = updateEmployee.get();

            employeeUpdate.setFirstName(employeeDetails.getFirstName());
            employeeUpdate.setLastName(employeeDetails.getLastName());
            employeeUpdate.setEmail(employeeDetails.getEmail());
            employeeUpdate.setPhotoUrl(employeeDetails.getPhotoUrl());
            employeeUpdate.setEmployeeDepartment(employeeDetails.getEmployeeDepartment());
            employeeUpdate.setStatus(employeeDetails.getStatus());
            employeeUpdate.setEmployeeTitle(employeeDetails.getEmployeeTitle());

            employeeRepository.save(employeeUpdate);
            return ResponseEntity.ok(employeeUpdate);
        }else  {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found!");
        }
    }

    public ResponseEntity<HttpStatus> deleteEmployeeByID(@PathVariable long id){
        Optional<Employee> deleteEmployee = employeeRepository.findById(id);

        if(deleteEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Employee with id: " + id + " not found!");
        }
        employeeRepository.delete(deleteEmployee.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
