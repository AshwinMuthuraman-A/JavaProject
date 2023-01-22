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
	public User createUser(User user) throws ConstraintViolationException, UserCollectionException {
		Optional<User> userExist = userRepos.findByUserEmail(user.getUserEmail());
		if(userExist.isPresent()) {
			throw new UserCollectionException(UserCollectionException.EmailAlreadyExists());
		}
		else {
			userRepos.insert(user);
			user.setUserId(user.getId().toString());
			userRepos.save(user);
			return user;
		}
	}
	
	@Override
	public User loginUser(String userEmail, String userPassword) throws UserCollectionException {
		Optional<User> userExist = userRepos.findByUserEmail(userEmail);
		if(userExist.isEmpty()) {
			throw new UserCollectionException(UserCollectionException.EmailNotExists());
		}
		else {
			User user = userExist.get();
			if(!(user.getUserPassword().equals(userPassword)))
				throw new UserCollectionException(UserCollectionException.PasswordNotMatching());
			else 
				return user;
		}
	}
	
	@Override
	public String getNameFromId(String userId) throws UserCollectionException {
		User user = getUserById(userId);
		return user.getUserName();
	}
	
	@Override
	public void addCourseToUser(String userId, String courseId) throws UserCollectionException {
		User user = getUserById(userId);
		user.addCourse(courseId);
		userRepos.save(user);
	}
	
	@Override
	public User getUserById(String userId) throws UserCollectionException {
		Optional<User> userExist = userRepos.findById(userId);
		if(userExist.isPresent()) {
			return userExist.get();
		}
		else
			throw new UserCollectionException(UserCollectionException.EmailNotExists());
	}
}