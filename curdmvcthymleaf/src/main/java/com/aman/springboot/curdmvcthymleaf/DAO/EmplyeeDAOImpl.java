package com.aman.springboot.curdmvcthymleaf.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aman.springboot.curdmvcthymleaf.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmplyeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmplyeeDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee order by firstName", Employee.class);
		
		List<Employee> employee=theQuery.getResultList();
		
		return employee;
	}

	
	@Override
	public Employee findById(Integer id) {
		Employee theEmployee=entityManager.find(Employee.class, id);
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		Employee dbEmployee=entityManager.merge(theEmployee);
		return dbEmployee;
	}

	@Override
	public void deleteById(Integer id) {
		Employee dbEmployee=entityManager.find(Employee.class, id);
		
		entityManager.remove(dbEmployee);
		
	}

}