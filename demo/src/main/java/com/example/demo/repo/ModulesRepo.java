package com.example.demo.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Modules;

public interface ModulesRepo extends MongoRepository<Modules, ObjectId> {

}
