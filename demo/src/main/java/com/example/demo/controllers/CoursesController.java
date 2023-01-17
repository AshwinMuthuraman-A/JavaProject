package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Courses;
import com.example.demo.repo.CoursesRepo;
import com.example.demo.services.CoursesService;

@RestController
@CrossOrigin("*")
@RequestMapping("/courses")
public class CoursesController {
	
	@Autowired
	private CoursesRepo coursesRepos;
	
	@Autowired
	private CoursesService coursesService;
	
	@GetMapping(value = "/searchall")
	public List<Courses> getAllCourses() {
		return coursesRepos.findAll();
	}
	
	@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> createNewCourse(@RequestPart("course") String courseValues, @RequestPart("imageFile") MultipartFile imageFile) {
		try {
			Courses course = coursesService.createCourse(courseValues, imageFile);
			return new ResponseEntity<Courses> (course, HttpStatus.OK);
		} catch(IOException ioe) {
			return new ResponseEntity<>(ioe.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
}