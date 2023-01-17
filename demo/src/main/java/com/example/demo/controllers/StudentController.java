package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.StudentCollectionException;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.services.StudentService;

import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	public StudentRepo studentrepos;
	
	@Autowired
	public StudentService studentservice;
	
	@GetMapping(value = "/all")
	public List<Student> getAllStudents() {
		return studentrepos.findAll();
	}
	
	@GetMapping(value = "/search/{name}")
	public List<Student> search(@PathVariable String name) {
		return studentrepos.findByName(name);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<?> createStudent(@RequestBody Student s) {
		try {
			studentservice.createStudent(s);
			return new ResponseEntity<Student> (s, HttpStatus.OK);
		} catch(ConstraintViolationException cve) {
			return new ResponseEntity<>(cve.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (StudentCollectionException sce) {
			return new ResponseEntity<>(sce.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = "/update/{text}")
	public String updateStudent(@RequestBody Student s, @PathVariable String text) {
		return studentservice.update(text, s);
	}
	
	@DeleteMapping(value = "/delete/{text}")
	public Student deleteStudent(@PathVariable String text) {
		return studentservice.remove(text);
	}
}
