package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repo.SearchRepo;
import com.example.demo.repo.StudentRepo;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	public StudentRepo studentrepos;
	
	@Autowired
	public SearchRepo searchrepos;
	
	@GetMapping(value = "/all")
	public List<Student> getAllStudents() {
		return studentrepos.findAll();
	}
	
	@GetMapping(value = "/search/{text}")
	public List<Student> search(@PathVariable String text) {
		return searchrepos.findByText(text);
	}
	
	@PostMapping(value = "/create")
	public String createStudent(@RequestBody Student s) {
		Student insertedStud = studentrepos.insert(s);
		return "Student created!" + insertedStud.getName();
	}
	
	@PutMapping(value = "/update/{text}")
	public String updateStudent(@RequestBody Student s, @PathVariable String text) {
		return searchrepos.update(text, s);
	}
	
	@DeleteMapping(value = "/delete/{text}")
	public Student deleteStudent(@PathVariable String text) {
		return searchrepos.remove(text);
	}
}
