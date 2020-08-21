package com.example.demo.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentForm {
	@NotNull(message="Name can't be blank")
	@Size(min=2, max=30)
	public String name;
	
	@NotNull
	@Min(18)
	public int age;
	
	@NotNull
	@Size(min=2, max=30)
	public String branch;
	

	
	public StudentForm(String name, int age, String branch) {
		super();
		this.name = name;
		this.age = age;
		this.branch = branch;
	}
	
	public StudentForm() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
	
	
}
