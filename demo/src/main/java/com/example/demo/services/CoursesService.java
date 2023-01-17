package com.example.demo.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Courses;

public interface CoursesService {
	public Courses createCourse(String courseValues, MultipartFile imageFile) throws IOException;
}
