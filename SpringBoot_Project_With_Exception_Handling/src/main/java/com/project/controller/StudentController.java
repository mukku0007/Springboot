package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.model.StudentViewModel;
import com.project.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/")
	public String getStudent(Model model) {
		List<Student> studentList = studentRepository.findAll();
		model.addAttribute("studentList", StudentViewModel.builder().studentList(studentList).build());
		model.addAttribute("student", Student.builder().build());
		return "index";
	}
}
