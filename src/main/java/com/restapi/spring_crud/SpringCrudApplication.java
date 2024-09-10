package com.restapi.spring_crud;

import com.restapi.spring_crud.api.model.Employee;
import com.restapi.spring_crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrudApplication implements CommandLineRunner {


	@Autowired
	public EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}


	@Override
	public void run(String... args) {
		Employee employee = new Employee();
		employee.setFirstName("Samuella");
		employee.setLastName("Mugisha");
		employee.setEmail("itsmugishasamuella@gmail.com");
		employeeRepository.save(employee);

		Employee employee2 = new Employee();
		employee2.setFirstName("Kevine");
		employee2.setLastName("Uwase");
		employee2.setEmail("uwasekevine21@gmail.com");
		employeeRepository.save(employee2);
	}
}
