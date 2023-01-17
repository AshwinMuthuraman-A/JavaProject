package com.example.demo.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Courses;

public interface CoursesRepo extends MongoRepository<Courses, ObjectId> {

}
