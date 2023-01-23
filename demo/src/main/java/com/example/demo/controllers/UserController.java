package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.Exceptions.CoursesCollectionException;
import com.example.demo.Exceptions.ModulesCollectionException;
import com.example.demo.Exceptions.UserCollectionException;
import com.example.demo.Exceptions.UserCourseDetailsCollectionException;
import com.example.demo.model.LoginDetails;
import com.example.demo.model.User;
import com.example.demo.services.UserCourseDetailsService;
import com.example.demo.services.UserService;

import jakarta.validation.ConstraintViolationException;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCourseDetailsService ucDetailsService;
	
	@PostMapping(value = "/signup")
	public ResponseEntity<?> userSignup(@RequestBody User user) {
		try {
			User createdUser = userService.createUser(user);
			return new ResponseEntity<User> (createdUser, HttpStatus.OK);
		} catch(ConstraintViolationException cve) {
			return new ResponseEntity<>(cve.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (UserCollectionException uce) {
			return new ResponseEntity<>(uce.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> userLogin(@RequestBody LoginDetails loginDetails) {
		try {
			User user = userService.loginUser(loginDetails.getLoginEmail(), loginDetails.getLoginPassword());
			return new ResponseEntity<User> (user, HttpStatus.OK);
		} catch (UserCollectionException uce) {
			return new ResponseEntity<>(uce.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = "/register-course")
	public ResponseEntity<?> registerCourse(@RequestPart("userId") String userId, @RequestPart("courseId") String courseId) {
		try {
			ucDetailsService.registerUserToCourse(userId, courseId);
			return new ResponseEntity<String>("Course Registered Successfully!", HttpStatus.OK);
		} catch (CoursesCollectionException cce) {
			return new ResponseEntity<>(cce.getMessage(), HttpStatus.NOT_FOUND);
		} catch (UserCollectionException uce) {
			return new ResponseEntity<>(uce.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/update-module-markasread")
	public ResponseEntity<?> updateModuleonMarkAsRead(@RequestPart("userId") String userId, 
													  @RequestPart("courseId") String courseId,
													  @RequestPart("moduleId") String moduleId) {
		try {
			ucDetailsService.updateOnMarkAsRead(userId, courseId, moduleId);
			return new ResponseEntity<String>("Update Successful!", HttpStatus.OK);
		} catch(UserCollectionException uce) {
			return new ResponseEntity<>(uce.getMessage(), HttpStatus.NOT_FOUND);
		}
		catch (CoursesCollectionException cce) {
			return new ResponseEntity<>(cce.getMessage(), HttpStatus.NOT_FOUND);
		}
		catch (ModulesCollectionException mce) {
			return new ResponseEntity<>(mce.getMessage(), HttpStatus.NOT_FOUND);
		} catch (UserCourseDetailsCollectionException ucdce) {
			return new ResponseEntity<>(ucdce.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
