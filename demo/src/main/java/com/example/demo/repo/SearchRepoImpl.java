package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

@Component
public class SearchRepoImpl implements SearchRepo {

	@Autowired
	MongoTemplate mt;
	
	@Override
	public List<Student> findByText(String text) {
		Query q = new Query();
		q.addCriteria(Criteria.where("name").is(text));
		List<Student> stsearch = mt.find(q, Student.class);
		return stsearch;
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
