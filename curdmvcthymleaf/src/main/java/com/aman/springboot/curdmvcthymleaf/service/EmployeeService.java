package com.aman.springboot.curdmvcthymleaf.service;

import java.util.List;

import com.aman.springboot.curdmvcthymleaf.entity.Employee;


public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(Integer id);
	
	Employee save(Employee theEmployee);
	
	void deleteById(Integer id);

}

