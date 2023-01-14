package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Student;

public interface StudentRepo extends MongoRepository<Student, ObjectId> {
	Optional<Student> findByEmail(String email);
	List<Student> findByName(String name);
}
