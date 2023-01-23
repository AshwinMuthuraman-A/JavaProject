package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Exceptions.UserCollectionException;
import com.example.demo.Exceptions.UserCourseDetailsCollectionException;
import com.example.demo.model.UserCourseDetails;
import com.example.demo.services.UserCourseDetailsService;
import com.example.demo.services.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user-course-details")
public class UserCourseDetailsController {
	
	@Autowired
	private UserCourseDetailsService ucDetailsService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/getall")
	public ResponseEntity<?> getAllUcdetailsOfUser(@RequestPart("userId") String userId) {
		try {
			List<String> ucDetailsIdList = userService.getAllUcdetails(userId);
			List<UserCourseDetails> ucDetailsList = new ArrayList<UserCourseDetails>();
			for(String ucDetailsId : ucDetailsIdList) {
				ucDetailsList.add(ucDetailsService.getUcdetailsById(ucDetailsId));
			}
			return new ResponseEntity<List<UserCourseDetails>>(ucDetailsList, HttpStatus.OK);
		} catch (UserCollectionException uce) {
			return new ResponseEntity<>(uce.getMessage(), HttpStatus.NOT_FOUND);
		} catch (UserCourseDetailsCollectionException ucdce) {
			return new ResponseEntity<>(ucdce.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/get-ucdetails")
	public ResponseEntity<?> getUcdetails(@RequestPart("ucDetailsId") String ucDetailsId) {
		try {
			UserCourseDetails ucDetails = ucDetailsService.getUcdetailsById(ucDetailsId);
			return new ResponseEntity<UserCourseDetails>(ucDetails, HttpStatus.OK);
		} catch (UserCourseDetailsCollectionException ucdce) {
			return new ResponseEntity<>(ucdce.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
