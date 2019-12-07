package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		TypedQuery<Employee> theQuery = this.entityManager.createQuery("from Employee", Employee.class);

		// Execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {

		// Get employee
		Employee theEmployee = this.entityManager.find(Employee.class, theId);

		// Return employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		// Save or Update the employee
		Employee dbEmployee = this.entityManager.merge(theEmployee);

		// Update with id from db ... so we can get generated id for save/update
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {

		// Delete object with primary key
		Query theQuery = this.entityManager.createQuery("delete from Employee where id=:employeeId");

		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();

	}

}
