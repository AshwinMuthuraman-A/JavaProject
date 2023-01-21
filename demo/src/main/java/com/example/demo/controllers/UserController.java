package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.Exceptions.UserCollectionException;
import com.example.demo.model.LoginDetails;
import com.example.demo.model.User;
import com.example.demo.services.UserService;

import jakarta.validation.ConstraintViolationException;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/signup")
	public ResponseEntity<?> userSignup(@RequestBody User user) {
		try {
			String userId = userService.createUser(user);
			return new ResponseEntity<String> (userId, HttpStatus.OK);
		} catch(ConstraintViolationException cve) {
			return new ResponseEntity<>(cve.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (UserCollectionException uce) {
			return new ResponseEntity<>(uce.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value = "/login")
	public ResponseEntity<?> userLogin(@RequestBody LoginDetails loginDetails) {
		try {
			String userId = userService.loginUser(loginDetails.getLoginEmail(), loginDetails.getLoginPassword());
			return new ResponseEntity<String> (userId, HttpStatus.OK);
		} catch (UserCollectionException uce) {
			return new ResponseEntity<>(uce.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = "/register-course")
	public ResponseEntity<?> registerCourse(@RequestPart("userId") String userId, @RequestPart("courseId") String courseId) {
		userService.addCourseToUser(userId, courseId);
		return new ResponseEntity<String>("Course Registered Successfully!", HttpStatus.OK);
	}
	
}
