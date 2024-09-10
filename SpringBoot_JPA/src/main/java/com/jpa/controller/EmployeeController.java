package com.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.model.Employee;
import com.jpa.repository.EmployeeRepository;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/insert")
	public String createNewEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "New employee inserted to the Database..!";
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		employeeRepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/get_emp/{city}")
	public ResponseEntity<List<Employee>> getEmployeeByCity(@PathVariable String city) {
		List<Employee> employee = employeeRepository.findByCity(city);
	    if (employee != null) {
	        return new ResponseEntity<>(employee, HttpStatus.FOUND);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/get_emp_age/{age}")
	public ResponseEntity<List<Employee>> getEmployeeByAge(@PathVariable int age) {
		List<Employee> employee = employeeRepository.findByAge(age);
		 if (employee.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // No employees found, return 404 Not Found
		    } else {
		        return new ResponseEntity<>(employee, HttpStatus.OK);  // Employees found, return 200 OK with the list
		    }
	}
	
	@PutMapping("/update/{id}")
	public String updateEmployeeById(@PathVariable long id, @RequestBody Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			Employee exitsEmployee = emp.get();
			exitsEmployee.setAge(employee.getAge());
			exitsEmployee.setCity(employee.getCity());
			exitsEmployee.setName(employee.getName());
			exitsEmployee.setSalary(employee.getSalary());

			employeeRepository.save(exitsEmployee);
			return "Employee Details of Id " + id + " Updated Successfully..!";

		} else {
			return "Employee doesn't exits for Emp Id " + id;
		}
	}
	
	@DeleteMapping("/delete/{id}") 
	public String deleteEmployeeById(@PathVariable long id) {
		employeeRepository.deleteById(id);
		return "Employee Deleted Successfully..!";
	}
	
	@DeleteMapping("/delete") 
	public String deleteAllEmployee() {
		employeeRepository.deleteAll();
		return "All Employee Deleted Successfully..!";
	}
	
}
