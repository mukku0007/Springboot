package com.dependency_injection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dependency_injection.service.HomeService;

@RestController
public class Field_Injection_Controller {

	@Autowired
	private HomeService homeService;  //Here it is field injection DI so we use @Autowired Annotation.
	
	@GetMapping("/field")
	public String getMessage() {
		return homeService.getMessage("Field Dependency Injection Methods");
	}
	
}
