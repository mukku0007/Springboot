package com.dependency_injection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dependency_injection.service.HomeService;


@RestController
public class Setter_Injection_Controller {

	
	private HomeService homeService;
	
	@Autowired
	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}
	
	
	@GetMapping("/setter")
	public String getMessage() {
		return homeService.getMessage("Setter Dependency Injection Methods");
	}
	
}
