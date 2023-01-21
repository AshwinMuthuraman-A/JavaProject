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
	
	@Autowired
	private CoursesService coursesService;
	
	@Override
	public void addUserCourseDetailsToUser(String userId, String courseId) throws CoursesCollectionException {
		Optional<User> userExist = userRepos.findById(userId);
		if(userExist.isPresent()) {
			User user = userExist.get();
			
			Courses course = coursesService.getCourseById(courseId);
			int n = course.getModulesList().size();
			List<Boolean> isCompleted= new ArrayList<Boolean>(Arrays.asList(new Boolean[n]));
			Collections.fill(isCompleted, Boolean.FALSE);
			
			UserCourseDetails ucDetails = new UserCourseDetails();
			ucDetails.setCourseId(courseId);
			ucDetails.setModulesCompleted(isCompleted);
			ucDetails.setModulesCompleted(null);
			ucDetailsRepos.insert(ucDetails);
			String ucDetailsId = ucDetails.getId().toString();
			ucDetails.setUserCourseDetailsId(ucDetailsId);
			ucDetailsRepos.insert(ucDetails);
			//doubt
			user.addCourse(ucDetailsId);
			userRepos.save(user);
		}
	}
	
	@Override
	public UserCourseDetails getucDetailsById(String ucDetailsId) {
		Optional<UserCourseDetails> ucDetailsExist = ucDetailsRepos.findById(ucDetailsId);
		if(ucDetailsExist.isPresent()) {
			UserCourseDetails ucDetails = ucDetailsExist.get();
			return ucDetails;
		}
		else
			return null;
	}
	
	@Override
	public String getCourseIdById(String ucDetailsId) {
		Optional<UserCourseDetails> ucDetailsExist = ucDetailsRepos.findById(ucDetailsId);
		if(ucDetailsExist.isPresent()) {
			UserCourseDetails ucDetails = ucDetailsExist.get();
			return ucDetails.getCourseId();
		}
		else
			return null;
	}
	
	@Override
	public void updateOnMarkAsRead(String userId, String courseId, String moduleId) throws CoursesCollectionException, ModulesCollectionException {
		//doubt
		Optional<User> userExist = userRepos.findById(userId);
		if(userExist.isPresent()) {
			User user = userExist.get();
			List<String> courseList = user.getCourseList();
			for(String ucDetailsId : courseList) {
				if(getCourseIdById(ucDetailsId).equals(courseId)) {
					Courses course = coursesService.getCourseById(courseId);
					int index = course.getModulesList().indexOf(moduleId);
					UserCourseDetails ucDetails = getucDetailsById(ucDetailsId);
					ucDetails.getModulesCompleted().set(index, true);
					ucDetailsRepos.save(ucDetails);
					break;
				}
			}
		}
	}
}
