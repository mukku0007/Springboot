package com.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Employee {

	@Id
	@Column
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String gender;
	
	@Column
	private String city;

	public Employee() {

	}

	public Employee(String name, long id, String gender, String city) {
		super();
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getcity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", gender=" + gender + ", city=" + city + "]";
	}
}
