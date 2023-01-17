package com.example.demo.services;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Courses;
import com.example.demo.repo.CoursesRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	private CoursesRepo coursesRepos;
	
	@Autowired
	private BinaryDataService bds;
	
	@Override
	public Courses createCourse(String courseValues, MultipartFile imageFile) throws IOException {
		Courses course = new Courses();
		ObjectMapper objectMapper = new ObjectMapper();
		course = objectMapper.readValue(courseValues, Courses.class);
		course.setImageId(bds.addFile(imageFile));
		coursesRepos.insert(course);
		return course;
	}	
}
