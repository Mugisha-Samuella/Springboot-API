package com.restapi.spring_crud;

import com.restapi.spring_crud.api.model.Employee;
import com.restapi.spring_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrudApplication{


	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}

	public void run(String... args) {

	}
}
