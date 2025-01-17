package com.dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dependency_injection.service.EmployeeService;
import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootDependencyInjectionSetterMethodApplication implements CommandLineRunner {

	// 1. Setter Method Dependency Injection
	
	//private EmployeeService employeeService;
	
//	@Autowired
//	public void setEmployeeService(EmployeeService employeeService) {
//		this.employeeService =  employeeService;
//	}
	
	// 2. Field Method Dependency Injection
	
	@Autowired
	//private EmployeeService employeeService;
	
	
	// 3. Constructor Method Dependency Injection
	
	//private final EmployeeService employeeService; 
	
//	public SpringBootDependencyInjectionSetterMethodApplication(EmployeeService employeeService) {
//		this.employeeService = employeeService;
//	}
	
	//private EmployeeService employeeService; // for this we can also use annotation which is @RequiredArgsConstructor for Constructor Method Dependency Injection
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDependencyInjectionSetterMethodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		//employeeService.printMessage("1. Setter Method Dependency Injection Called Here..!");
		//employeeService.printMessage("2. Field Method Dependency Injection Called Here..!");
		//employeeService.printMessage("3. Constructor Method Dependency Injection Called Here..!");
	}

}
