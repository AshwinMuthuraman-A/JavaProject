package com.example.demo.services;

import com.example.demo.Exceptions.UserCollectionException;
import com.example.demo.model.User;

import jakarta.validation.ConstraintViolationException;

public interface UserService {
	public User createUser(User user) throws ConstraintViolationException, UserCollectionException;
	public User loginUser(String userEmail, String userPassword) throws UserCollectionException;
	public User getUserById(String userId) throws UserCollectionException;
	public String getNameFromId(String userId) throws UserCollectionException;
	public void addCourseToUser(String userId, String courseId) throws UserCollectionException;
}
