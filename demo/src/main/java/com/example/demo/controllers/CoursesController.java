package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Exceptions.CoursesCollectionException;
import com.example.demo.Exceptions.UserCollectionException;
import com.example.demo.model.Courses;
import com.example.demo.repo.CoursesRepo;
import com.example.demo.services.CoursesService;
import com.example.demo.services.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/courses")
public class CoursesController {
	
	@Autowired
	private CoursesRepo coursesRepos;
	
	@Autowired
	private CoursesService coursesService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/searchall")
	public List<Courses> getAllCourses() {
		return coursesRepos.findAll();
	}
	
	@GetMapping(value="/get-course/{courseId}")
	public ResponseEntity<?>getCourse(@PathVariable String courseId){
		try {
			Courses course = coursesService.getCourseById(courseId);
			return new ResponseEntity<Courses>(course, HttpStatus.OK);
		} catch(CoursesCollectionException cce) {
			return new ResponseEntity<>(cce.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> createNewCourse(@RequestPart("instructorId") String instructorId,
			                                 @RequestPart("course") String courseValues, 
			                                 @RequestPart("imageFile") MultipartFile imageFile) {
		try {
			Courses course = coursesService.createCourse(instructorId, courseValues, imageFile);
			userService.addCourseToUser(instructorId, course.getCourseId());
			return new ResponseEntity<String> (course.getCourseId(), HttpStatus.OK);
		} catch(UserCollectionException uce) {
			return new ResponseEntity<>(uce.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
		} catch(IOException ioe) {
			return new ResponseEntity<>(ioe.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
}