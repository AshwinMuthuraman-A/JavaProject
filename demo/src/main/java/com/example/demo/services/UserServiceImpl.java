package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.UserCollectionException;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

import jakarta.validation.ConstraintViolationException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepos;
	
	@Override
	public String createUser(User user) throws ConstraintViolationException, UserCollectionException {
		Optional<User> userExist = userRepos.findByUserEmail(user.getUserEmail());
		if(userExist.isPresent()) {
			throw new UserCollectionException(UserCollectionException.EmailAlreadyExists());
		}
		else {
			userRepos.insert(user);
			user.setUserId(user.getId().toString());
			userRepos.save(user);
			return user.getUserId();
		}
	}
	
	@Override
	public String loginUser(String userEmail, String userPassword) throws UserCollectionException {
		Optional<User> userExist = userRepos.findByUserEmail(userEmail);
		if(userExist.isEmpty()) {
			throw new UserCollectionException(UserCollectionException.EmailNotExists());
		}
		else {
			User user = userExist.get();
			if(!(user.getUserPassword().equals(userPassword)))
				throw new UserCollectionException(UserCollectionException.PasswordNotMatching());
			else 
				return user.getUserId();
		}
	}
	
	@Override
	public String getNameFromId(String userId) {
		Optional<User> userExist = userRepos.findById(userId);
		if(userExist.isPresent()) {
			User user = userExist.get();
			return user.getUserName();
		}
		else
			return null;
	}
	
	@Override
	public void addCourseToUser(String userId, String courseId) {
		Optional<User> userExist = userRepos.findById(userId);
		if(userExist.isPresent()) {
			User user = userExist.get();
			user.addCourse(courseId);
			userRepos.save(user);
		}
	}	
}