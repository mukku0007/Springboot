package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.Student;
import com.jwt.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/welcome")
@AllArgsConstructor
public class HomeController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/home")
	public String getHome() {
		return "Welcome to the Rest API JWT";
	}
	
	@GetMapping("/getStudent")
	public List<Student> getStudent() {
		List<Student> studentList = studentService.getStudentList();
		return studentList;
	}
}
