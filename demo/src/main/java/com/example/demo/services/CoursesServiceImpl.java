package com.example.demo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	@Autowired
	private UserService userService;
	
	@Override
	public Courses createCourse(String instructorId, String courseValues, MultipartFile imageFile) throws IOException {
		Courses course = new Courses();
		ObjectMapper objectMapper = new ObjectMapper();
		course = objectMapper.readValue(courseValues, Courses.class);
		course.setImageId(bds.addFile(imageFile));
		course.setInstructorName(userService.getNameFromId(instructorId));
		coursesRepos.insert(course);
		return course;
	}

	@Override
	public void addModuletoCourse(String courseId, String moduleId) {
		Optional<Courses> courseExist = coursesRepos.findById(courseId);
		if(courseExist.isPresent()) {
			Courses course = courseExist.get();
			List<String> modulesList = course.getModulesList();
			if(modulesList==null)
				modulesList = new ArrayList<>();
			modulesList.add(moduleId);
			course.setModulesList(modulesList);
			coursesRepos.save(course);
		}
	}

	@Override
	public void addCountToCourse(String courseId) {
		Optional<Courses> courseExist = coursesRepos.findById(courseId);
		if(courseExist.isPresent()) {
			Courses course = courseExist.get();
			course.incrementNumOfStudentsRegistered();
			coursesRepos.save(course);
		}		
	}	
}
