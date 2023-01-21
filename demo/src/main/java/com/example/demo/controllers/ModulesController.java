package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Modules;
import com.example.demo.repo.ModulesRepo;
import com.example.demo.services.CoursesService;
import com.example.demo.services.ModulesService;

@RestController
@CrossOrigin("*")
@RequestMapping("/modules")
public class ModulesController {
	
	@Autowired
	private ModulesRepo modulesRepos;
	
	@Autowired
	private ModulesService modulesService;
	
	@Autowired
	private CoursesService coursesService;
	
	@GetMapping(value = "/searchall")
	public List<Modules> getAllCourses() {
		return modulesRepos.findAll();
	}
	
	@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> createNewCourse(@RequestPart("courseId") String courseId,
			                                 @RequestPart("module") String moduleValues, 
			                                 @RequestPart("pdfFile") MultipartFile pdfFile,
			                                 @RequestPart("videoFile") MultipartFile videoFile) {
		try {
			Modules module = modulesService.createModule(moduleValues, pdfFile, videoFile);
			coursesService.addModuletoCourse(courseId, module.getId().toString());
			return new ResponseEntity<Modules> (module, HttpStatus.OK);
		} catch(IOException ioe) {
			return new ResponseEntity<>(ioe.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
}
