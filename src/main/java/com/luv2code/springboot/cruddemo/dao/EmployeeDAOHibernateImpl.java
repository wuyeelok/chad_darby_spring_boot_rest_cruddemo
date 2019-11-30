package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private final EntityManager entityManager;

	// Set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// Execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// Return the results
		return employees;
	}

}
