package com.restapi.spring_crud.repository;

import com.restapi.spring_crud.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //All crud operations



}
