package com.luv2code.springboot.cruddemo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.springboot.cruddemo.dao.BookRepository;
import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.dao.PageRepository;
import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entity.Page;

@SpringBootApplication
public class CruddemoApplication {

	private static final Logger log = LoggerFactory.getLogger(CruddemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Testing only, create data in DB when server start
	@Bean
	public CommandLineRunner dbDataInit(EmployeeRepository employeeRepository, BookRepository bookRepository,
			PageRepository pageRepository) {
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

			// create a new book
			log.info("Start to create new book...");
			Book book = new Book("Java 101", "John Doe", "abcde");
			bookRepository.save(book);

			// fetch all book
			log.info("Book found with findAll():");
			log.info("---------------------------");
			for (Book b : bookRepository.findAll()) {
				log.info(b.toString());
			}

			// create & save new pages
			log.info("Start to create new pages...");
			pageRepository.save(new Page(1, "Introduction contents", "Introduction", book));
			pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
			pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));

			// fetch all page
			log.info("Page found with findAll():");
			log.info("---------------------------");
			for (Page p : pageRepository.findAll()) {
				log.info(p.toString());
			}

			// call find findByIsbn
			Book tempB = bookRepository.findByIsbn("ABCDE");
			if (tempB != null) {
				log.info("Found tempB");
			} else {
				log.info("tempB not found!");
			}

			// call find findByIsbnContaining
			List<Book> tempCList = bookRepository.findByIsbnContaining("aBCde");
			if (tempCList != null && !tempCList.isEmpty()) {
				log.info("Found tempCList");
			} else {
				log.info("tempCList NOT found!");
			}

		};
	}
}
