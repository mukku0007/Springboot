package com.sp.main.bean;

public class Student {

	private String name;
	private int rollno;
	private float marks;

	public Student() {

	}

	public Student(String name, int rollno, float marks) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}
	
	public void displayDetails() {
		System.out.println("Name: "+name);
		System.out.println("Roll No: "+rollno);
		System.out.println("Marks: "+marks);
	}

}
