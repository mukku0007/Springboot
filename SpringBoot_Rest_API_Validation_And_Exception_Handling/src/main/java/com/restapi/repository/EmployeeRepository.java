package com.restapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restapi.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	public Optional<Employee> getByAge(Integer age);
	
	public Optional<Employee> getByName(String name);
		
}
