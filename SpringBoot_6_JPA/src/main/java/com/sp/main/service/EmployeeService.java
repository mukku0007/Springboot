package com.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.main.entity.Employee;
import com.sp.main.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee insertEmployee(Employee employee) {
		 Employee savedEmployee = employeeRepository.save(employee);
		 return savedEmployee;
	}
}
