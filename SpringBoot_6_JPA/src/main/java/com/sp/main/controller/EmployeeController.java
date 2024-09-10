package com.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.main.entity.Employee;
import com.sp.main.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/welcome")
	@ResponseBody
	public String welcomeMessage() {
		return "Welocme to Spring Boot Data JPA";
	}
	
	@PostMapping("/insert_employee")
	public Employee insert(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.insertEmployee(employee);
		return savedEmployee;
	}
}
