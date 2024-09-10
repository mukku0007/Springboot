package com.autentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		return "Welcome..!";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
}
