package com.aman.springboot.curdmvcthymleaf.DAO;

import java.util.List;

import com.aman.springboot.curdmvcthymleaf.entity.Employee;



public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(Integer id);
	
	Employee save(Employee theEmployee);
	
	void deleteById(Integer id);
}

