package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository("empDAOJpaImpl")
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private final EntityManager entityManager;

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		// Create a query
		Query theQuery = this.entityManager.createQuery("from Employee");

		// Execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
