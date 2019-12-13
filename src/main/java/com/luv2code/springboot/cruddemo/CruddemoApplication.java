package com.luv2code.springboot.cruddemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@SpringBootApplication
public class CruddemoApplication {

	private static final Logger log = LoggerFactory.getLogger(CruddemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Testing only, create data in DB when server start
	@Bean
	public CommandLineRunner dbDataInit(EmployeeRepository employeeRepository) {
		return (args) -> {

			// create dummy employee
			log.info("Start to create dummy employee...");
			employeeRepository.save(new Employee("Leslie", "Andrews", "leslie@luv2code.com"));
			employeeRepository.save(new Employee("Emma", "Baumgarten", "emma@luv2code.com"));
			employeeRepository.save(new Employee("Avani", "Gupta", "avani@luv2code.com"));
			employeeRepository.save(new Employee("Yuri", "Petrov", "yuri@luv2code.com"));
			employeeRepository.save(new Employee("Juan", "Vega", "juan@luv2code.com"));

			// fetch all employee
			log.info("Employee found with findAll():");
			log.info("---------------------------");
			for (Employee employee : employeeRepository.findAll()) {
				log.info(employee.toString());
			}

		};
	}
}
