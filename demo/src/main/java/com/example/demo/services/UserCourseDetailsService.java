package com.example.demo.services;

import com.example.demo.Exceptions.CoursesCollectionException;
import com.example.demo.Exceptions.ModulesCollectionException;
import com.example.demo.model.UserCourseDetails;

public interface UserCourseDetailsService {

	void addUserCourseDetailsToUser(String userId, String courseId) throws CoursesCollectionException;

	void updateOnMarkAsRead(String userId, String courseId, String moduleId)
			throws CoursesCollectionException, ModulesCollectionException;

	String getCourseIdById(String ucDetailsId);

	UserCourseDetails getucDetailsById(String ucDetailsId);

}
