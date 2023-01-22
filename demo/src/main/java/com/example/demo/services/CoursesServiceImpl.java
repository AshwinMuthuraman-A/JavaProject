package com.example.demo.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Exceptions.CoursesCollectionException;
import com.example.demo.Exceptions.UserCollectionException;
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
	public Courses createCourse(String instructorId, String courseValues, MultipartFile imageFile) throws IOException, UserCollectionException {
		Courses course = new Courses();
		ObjectMapper objectMapper = new ObjectMapper();
		course = objectMapper.readValue(courseValues, Courses.class);
		course.setImageId(bds.addFile(imageFile));
		course.setInstructorName(userService.getNameFromId(instructorId));
		coursesRepos.insert(course);
		course.setCourseId(course.getId().toString());
		coursesRepos.save(course);
		return course;
	}

	@Override
	public void addModuletoCourse(String courseId, String moduleId) throws CoursesCollectionException {
		Courses course = getCourseById(courseId);
		course.includeModule(moduleId);
		coursesRepos.save(course);
	}
	
	@Override
	public List<String> getAllModules(String courseId) throws CoursesCollectionException {
		Courses course = getCourseById(courseId);
		return course.getModulesList();
	}

	@Override
	public void addCountToCourse(String courseId) throws CoursesCollectionException {
		Courses course = getCourseById(courseId);
		course.incrementNumOfStudentsRegistered();
		coursesRepos.save(course);		
	}

	@Override
	public Courses getCourseById(String courseId) throws CoursesCollectionException {
		Optional<Courses> courseExist = coursesRepos.findById(courseId);
		if(courseExist.isPresent()) {
			return courseExist.get();
		}
		else
			throw new CoursesCollectionException(CoursesCollectionException.CoursesNotFound());
	}	
}
