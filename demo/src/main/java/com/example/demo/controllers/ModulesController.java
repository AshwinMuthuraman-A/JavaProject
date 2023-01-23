package com.example.demo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Exceptions.CoursesCollectionException;
import com.example.demo.Exceptions.ModulesCollectionException;
import com.example.demo.model.Modules;
import com.example.demo.services.CoursesService;
import com.example.demo.services.ModulesService;

@RestController
@CrossOrigin("*")
@RequestMapping("/modules")
public class ModulesController {
	
	@Autowired
	private ModulesService modulesService;
	
	@Autowired
	private CoursesService coursesService;
	
	@GetMapping(value = "/getall")
	public ResponseEntity<?> getAllModulesOfCourse(@RequestPart("courseId") String courseId) {
		try {
			List<String> modulesIdList = coursesService.getAllModules(courseId);
			List<Modules> modulesList = new ArrayList<Modules>();
			for(String moduleId : modulesIdList) {
				modulesList.add(modulesService.getModuleById(moduleId));
			}
			return new ResponseEntity<List<Modules>>(modulesList, HttpStatus.OK);
		} catch (CoursesCollectionException cce) {
			return new ResponseEntity<>(cce.getMessage(), HttpStatus.NOT_FOUND);
		} catch (ModulesCollectionException mce) {
			return new ResponseEntity<>(mce.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/get-module/{moduleId}")
	public ResponseEntity<?> getModule(@PathVariable String moduleId) {
		try {
			Modules module = modulesService.getModuleById(moduleId);
			return new ResponseEntity<Modules>(module, HttpStatus.OK);
		} catch(ModulesCollectionException mce) {
			return new ResponseEntity<>(mce.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> createNewModule(@RequestPart("module") String moduleValues, 
			                                 @RequestPart("pdfFile") MultipartFile pdfFile,
			                                 @RequestPart("videoFile") MultipartFile videoFile) {
		try {
			Modules module = modulesService.createModule(moduleValues, pdfFile, videoFile);
			coursesService.addModuletoCourse(module.getCourseId(), module.getModuleId());
			return new ResponseEntity<String>(module.getModuleId(), HttpStatus.OK);
		} catch(IOException ioe) {
			return new ResponseEntity<>(ioe.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
		} catch (CoursesCollectionException cce) {
			return new ResponseEntity<>(cce.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
}
