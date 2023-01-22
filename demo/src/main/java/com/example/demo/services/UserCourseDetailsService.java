package com.example.demo.services;

import com.example.demo.Exceptions.CoursesCollectionException;
import com.example.demo.Exceptions.ModulesCollectionException;
import com.example.demo.Exceptions.UserCollectionException;
import com.example.demo.Exceptions.UserCourseDetailsCollectionException;
import com.example.demo.model.UserCourseDetails;

public interface UserCourseDetailsService {

	void registerUserToCourse(String userId, String courseId) throws CoursesCollectionException, UserCollectionException;

	void updateOnMarkAsRead(String userId, String courseId, String moduleId)
			throws CoursesCollectionException, ModulesCollectionException, UserCollectionException, UserCourseDetailsCollectionException;

	String getCourseIdById(String ucDetailsId) throws UserCourseDetailsCollectionException;

	UserCourseDetails getUcdetailsById(String ucDetailsId) throws UserCourseDetailsCollectionException;

}
