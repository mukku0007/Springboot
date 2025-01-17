package com.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.model.Student;

@Service
public class StudentService {

	private List<Student> studentList = new ArrayList<>();
	
	public StudentService() {


		 // Creating multiple Student objects
        Student student1 = new Student(101, "Mukesh", "mukesh@gmail.com");
        Student student2 = new Student(102, "John", "john@gmail.com");
        Student student3 = new Student(103, "Emily", "emily@gmail.com");
        Student student4 = new Student(104, "Sara", "sara@gmail.com");

        // Adding the Student objects to the list
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}
	
}
