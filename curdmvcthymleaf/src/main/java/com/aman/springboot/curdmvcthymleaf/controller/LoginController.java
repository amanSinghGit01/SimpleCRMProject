package com.aman.springboot.curdmvcthymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showLoginForm() {
		return "employees/plain-login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "employees/access-denied";
	}
}
