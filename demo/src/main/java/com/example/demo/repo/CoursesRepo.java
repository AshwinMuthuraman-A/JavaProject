package com.example.demo.repo;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Courses;

public interface CoursesRepo extends MongoRepository<Courses, ObjectId> {
	Optional<Courses> findById(String courseId);
}
