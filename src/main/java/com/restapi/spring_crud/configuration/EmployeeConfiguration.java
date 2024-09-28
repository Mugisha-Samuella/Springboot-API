package com.restapi.spring_crud.configuration;

import com.restapi.spring_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {


    @Autowired
    public EmployeeRepository employeeRepository;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
//            Employee employee = new Employee();
//            employee.setFirstName("Samuella");
//            employee.setLastName("Mugisha");
//            employee.setEmail("itsmugishasamuella@gmail.com");
//            employeeRepository.save(employee);
//
//            Employee employee2 = new Employee();
//            employee2.setFirstName("Kevine");
//            employee2.setLastName("Uwase");
//            employee2.setEmail("uwasekevine21@gmail.com");
//            employeeRepository.save(employee2);
        };
    }
}
