package com.example.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.CoursesCollectionException;
import com.example.demo.Exceptions.ModulesCollectionException;
import com.example.demo.Exceptions.UserCollectionException;
import com.example.demo.Exceptions.UserCourseDetailsCollectionException;
import com.example.demo.model.Courses;
import com.example.demo.model.User;
import com.example.demo.model.UserCourseDetails;
import com.example.demo.repo.UserCourseDetailsRepo;
import com.example.demo.repo.UserRepo;

@Service
public class UserCourseDetailsServiceImpl implements UserCourseDetailsService{
	
	@Autowired
	private UserCourseDetailsRepo ucDetailsRepos;
	
	@Autowired
	private UserRepo userRepos;
	
	@Autowired UserService userService;
	
	@Autowired
	private CoursesService coursesService;
	
	@Override
	public void registerUserToCourse(String userId, String courseId) throws CoursesCollectionException, UserCollectionException {
		
		User user = userService.getUserById(userId);
		
		coursesService.addCountToCourse(courseId);
		Courses course = coursesService.getCourseById(courseId);
		int n = course.getModulesList().size();
		List<Boolean> isCompleted= new ArrayList<Boolean>(Arrays.asList(new Boolean[n]));
		Collections.fill(isCompleted, Boolean.FALSE);
		UserCourseDetails ucDetails = new UserCourseDetails();
		ucDetails.setCourseId(courseId);
		ucDetails.setModulesCompleted(isCompleted);
		ucDetailsRepos.insert(ucDetails);
		String ucDetailsId = ucDetails.getId().toString();
		ucDetails.setUserCourseDetailsId(ucDetailsId);
		ucDetailsRepos.save(ucDetails);
		user.addCourse(ucDetailsId);
		userRepos.save(user);
	}
	
	@Override
	public UserCourseDetails getUcdetailsById(String ucDetailsId) throws UserCourseDetailsCollectionException {
		Optional<UserCourseDetails> ucDetailsExist = ucDetailsRepos.findById(ucDetailsId);
		if(ucDetailsExist.isPresent()) {
			UserCourseDetails ucDetails = ucDetailsExist.get();
			return ucDetails;
		}
		else
			throw new UserCourseDetailsCollectionException(UserCourseDetailsCollectionException.UCDetailsNotFound());
	}
	
	@Override
	public String getCourseIdById(String ucDetailsId) throws UserCourseDetailsCollectionException {
		Optional<UserCourseDetails> ucDetailsExist = ucDetailsRepos.findById(ucDetailsId);
		if(ucDetailsExist.isPresent()) {
			UserCourseDetails ucDetails = ucDetailsExist.get();
			return ucDetails.getCourseId();
		}
		else
			throw new UserCourseDetailsCollectionException(UserCourseDetailsCollectionException.UCDetailsNotFound());
	}
	
	@Override
	public void updateOnMarkAsRead(String userId, String courseId, String moduleId) 
			throws CoursesCollectionException, ModulesCollectionException, UserCollectionException, UserCourseDetailsCollectionException {
		User user = userService.getUserById(userId);
		List<String> courseList = user.getCourseList();
		for(String ucDetailsId : courseList) {
			if(getCourseIdById(ucDetailsId).equals(courseId)) {
				
				UserCourseDetails ucDetails = getUcdetailsById(ucDetailsId);
				
				Courses course = coursesService.getCourseById(courseId);
				int index = course.getModulesList().indexOf(moduleId);
				ucDetails.getModulesCompleted().set(index, true);
				ucDetails.updateCourseCompletedPercentage();
		
				ucDetailsRepos.save(ucDetails);
				break;
			}
		}
	}
}
