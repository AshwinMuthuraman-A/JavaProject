package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Exceptions.StudentCollectionException;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

import jakarta.validation.ConstraintViolationException;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentrepos;
	
	@Autowired
	MongoTemplate mt;
	
	@Override
	public void createStudent(@RequestBody Student s) throws ConstraintViolationException, StudentCollectionException {
		Optional<Student> studentExist = studentrepos.findByEmail(s.getEmail());
		if(studentExist.isPresent()) {
			throw new StudentCollectionException(StudentCollectionException.EmailAlreadyExists());
		}
		else {
			studentrepos.insert(s);
		}
	}

	@Override
	public String update(String text, Student s) {
		Query q = new Query();
		q.addCriteria(Criteria.where("name").is(text));
		Update upd = new Update();
		upd.set("marks", s.getMarks());
		upd.set("name", s.getName());
		mt.findAndModify(q, upd, Student.class);
		return "Updated";
	}

	@Override
	public Student remove(String text) {
		Query q = new Query();
		q.addCriteria(Criteria.where("name").is(text));
		Student s = mt.findAndRemove(q, Student.class);
		System.out.println(s.getId().toString());
		return s;
	}

}
