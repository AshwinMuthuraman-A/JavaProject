package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Student;

//@Repository
public interface StudentRepo extends MongoRepository<Student, Long> {
	
}
