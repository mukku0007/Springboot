package com.dependency_injection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dependency_injection.service.HomeService;

@RestController
public class Constructor_Injection_Controller {

	private final HomeService homeService;
	
	public Constructor_Injection_Controller(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@GetMapping("/constructor")
	public String getMessage() {
		return homeService.getMessage("Constructor Dependency Injection Methods");
	}
	
}
