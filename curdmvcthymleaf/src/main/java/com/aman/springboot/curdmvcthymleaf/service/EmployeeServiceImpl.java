package com.aman.springboot.curdmvcthymleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aman.springboot.curdmvcthymleaf.DAO.EmployeeDAO;
import com.aman.springboot.curdmvcthymleaf.entity.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO=employeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteById(id);
		
	}

}
