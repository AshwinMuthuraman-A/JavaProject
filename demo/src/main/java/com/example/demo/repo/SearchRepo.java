package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.Student;

public interface SearchRepo {
	List<Student> findByText(String text);
	String update(String text, Student s);
	Student remove(String text);
}
