package com.example.demo.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Courses {
	
	@Id
	private ObjectId id;
	
	private String courseName;
	private String instructorName;
	private String imageId;
	private List<ObjectId> modulesList;
	private int numberOfStudentsRegistered;
	
	public Courses() {
		super();
	}
	
	public Courses(String courseName, List<ObjectId> modulesList) {
		super();
		this.courseName = courseName;
		this.modulesList = modulesList;
		numberOfStudentsRegistered = 0;
		instructorName = null;
	}
	
	public ObjectId getId() {
		return id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public List<ObjectId> getModulesList() {
		return modulesList;
	}
	public void setModulesList(List<ObjectId> modulesList) {
		this.modulesList = modulesList;
	}
	public int getNumberOfStudentsRegistered() {
		return numberOfStudentsRegistered;
	}
	public void setNumberOfStudentsRegistered(int numberOfStudentsRegistered) {
		this.numberOfStudentsRegistered = numberOfStudentsRegistered;
	}
}
