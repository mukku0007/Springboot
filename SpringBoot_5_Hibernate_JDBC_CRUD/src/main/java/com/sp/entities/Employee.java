package com.sp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

	@Id
	@Column
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String gender;
	
	@Column
	private String cityString;

	public Employee() {

	}

	public Employee(String name, long id, String gender, String cityString) {
		super();
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.cityString = cityString;
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

	public String getCityString() {
		return cityString;
	}

	public void setCityString(String cityString) {
		this.cityString = cityString;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", gender=" + gender + ", cityString=" + cityString + "]";
	}
}
