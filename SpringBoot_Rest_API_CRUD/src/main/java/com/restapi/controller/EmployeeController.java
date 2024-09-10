package com.restapi.controller;

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

import com.restapi.model.Employee;
import com.restapi.repository.EmployeeRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/save")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body("Employee Created Successfully..");
	}
	
	@GetMapping("/get")
	public ResponseEntity<Object> getAllEmployee() {
		Iterable<Employee> allEmployee = employeeRepository.findAll();
		return ResponseEntity.status(HttpStatus.FOUND).body(allEmployee);
		
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable Integer id) {
		Optional<Employee> empOptional = employeeRepository.findById(id);
		if(!empOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found for Id "+id);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(empOptional);
		}
	}
	
	@PutMapping("/updateEmployeeById/{id}")
	public ResponseEntity<Object> updateEmployeeById(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if (employeeOptional.isPresent()) {
			Employee existingEmployee = employeeOptional.get();
			existingEmployee.setName(employee.getName());
			existingEmployee.setCity(employee.getCity());
			existingEmployee.setAge(employee.getAge());
			employeeRepository.save(existingEmployee);
			return ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully for Id " +id);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee is not Found for Id " +id);
		}
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<Object> deleteEmployeeById(@PathVariable Integer id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if(optionalEmployee.isPresent()) {
			employeeRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted Sucessfully for Id "+id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee is not Found for Id "+id);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Object> deleteEmployee() {
		employeeRepository.deleteAll();
		return ResponseEntity.status(HttpStatus.OK).body("All Employee are Deleted Sucessfully..");
	}
}
