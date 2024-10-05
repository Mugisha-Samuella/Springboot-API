package com.restapi.spring_crud.repository;

import com.restapi.spring_crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //All crud operations

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Optional<Employee> findEmployeeByEmail(String email);

    Optional<Employee> findByEmail(String email);
}
