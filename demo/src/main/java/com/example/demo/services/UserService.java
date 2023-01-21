package com.example.demo.services;

import com.example.demo.Exceptions.UserCollectionException;
import com.example.demo.model.User;

import jakarta.validation.ConstraintViolationException;

public interface UserService {
	public String createUser(User user) throws ConstraintViolationException, UserCollectionException;
	public String loginUser(String userEmail, String userPassword) throws UserCollectionException;
	public String getNameFromId(String userId);
	public void addCourseToUser(String userId, String courseId);
}
