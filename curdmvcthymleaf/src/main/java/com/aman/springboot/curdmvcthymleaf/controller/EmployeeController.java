package com.aman.springboot.curdmvcthymleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aman.springboot.curdmvcthymleaf.entity.Employee;
import com.aman.springboot.curdmvcthymleaf.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeServiceImpl employeeService;
	
	@Autowired
	public EmployeeController(EmployeeServiceImpl employeeService) {
		this.employeeService=employeeService;
	}
	
	
//	@GetMapping("/showMyLoginPage")
//	public String showLoginForm() {
//		return "employees/plain-login";
//	} 
	
	@GetMapping("/showInfo")
	public String showInfo(@RequestParam("employeeId")int id,Model theModel) {
		Employee theEmployee=employeeService.findById(id);
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/info-page";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId")int id) {
		employeeService.deleteById(id);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId")int id,Model theModel) {
		
		Employee theEmployee=employeeService.findById(id);
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		employeeService.save(employee);
		
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee=new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return"employees/employee-form";
	}
	
	@GetMapping("/list")
	public String listOfAllEmployee(Model theModel) {
		List<Employee> employees=employeeService.findAll();
		
		theModel.addAttribute("employees", employees);
		
		return "employees/list-employees";
	}
}
