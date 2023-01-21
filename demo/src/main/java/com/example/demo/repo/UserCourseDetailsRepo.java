package com.example.demo.repo;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.UserCourseDetails;

public interface UserCourseDetailsRepo extends MongoRepository<UserCourseDetails, ObjectId> {
	Optional<UserCourseDetails> findById(String courseId);
}
