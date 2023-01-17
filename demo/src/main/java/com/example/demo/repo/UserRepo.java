package com.example.demo.repo;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.User;

public interface UserRepo  extends MongoRepository<User, ObjectId> {
	Optional<User> findByUserEmail(String userEmail);
}

