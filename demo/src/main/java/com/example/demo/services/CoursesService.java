package com.example.demo.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Exceptions.CoursesCollectionException;
import com.example.demo.model.Courses;

public interface CoursesService {
	public Courses createCourse(String instructorId, String courseValues, MultipartFile imageFile) throws IOException;
	public void addModuletoCourse(String courseId, String moduleId);
	public void addCountToCourse(String courseId);
	public Courses getCourseById(String courseId) throws CoursesCollectionException;
	public List<String> getAllModules(String courseId) throws CoursesCollectionException;
}
