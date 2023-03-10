package com.example.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document(collection = "student")
public class Student {
	
	@Id
	private ObjectId id;
	
	@NotNull(message = "Name cannot be null")
	private String name;
	
	@NotNull(message = "Email cannot be null")
	private String email;
	private int age;
	private double marks;
	public Student() {
		super();
	}
	public Student(String name, String email, int age, double marks) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.marks = marks;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ObjectId getId() {
		return id;
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
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
}

