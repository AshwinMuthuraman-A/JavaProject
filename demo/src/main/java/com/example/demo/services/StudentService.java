package com.example.demo.services;

import com.example.demo.Exceptions.StudentCollectionException;
import com.example.demo.model.Student;

import jakarta.validation.ConstraintViolationException;

public interface StudentService {
	
	public void createStudent(Student s) throws ConstraintViolationException, StudentCollectionException;
	String update(String text, Student s);
	Student remove(String text);
}
