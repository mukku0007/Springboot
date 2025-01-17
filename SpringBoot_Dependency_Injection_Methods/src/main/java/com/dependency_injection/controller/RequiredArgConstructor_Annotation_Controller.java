package com.dependency_injection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dependency_injection.service.HomeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RequiredArgConstructor_Annotation_Controller {

	private final HomeService homeService;
	
	@GetMapping("/required_arg_constructor")
	public String getMessage() {
		return homeService.getMessage("@RequiredArgsConstructor Annotation Dependency Injection Methods");
	}
}
