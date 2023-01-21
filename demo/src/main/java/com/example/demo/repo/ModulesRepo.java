package com.example.demo.repo;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Modules;

public interface ModulesRepo extends MongoRepository<Modules, ObjectId> {
	Optional<Modules> findById(String moduleId);
}
