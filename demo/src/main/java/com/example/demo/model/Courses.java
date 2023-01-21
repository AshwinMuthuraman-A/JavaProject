package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Courses {
	
	@Id
	private ObjectId id;
	
	private String courseId;
	private String courseTitle;
	private String courseDesc;
	private String instructorName;
	private String courseLang;
	private List<String> importantKeyPoints;
	private List<String> highlightKeyPoints;
	private String imageId;
	private List<String> modulesList;
	private int numberOfStudentsRegistered;
	
	public Courses() {
		super();
		this.courseId = null;
		this.instructorName = null;
		this.modulesList = new ArrayList<String>();
		this.numberOfStudentsRegistered = 0;
	}

	public Courses(String courseTitle, String courseDesc, String courseLang, List<String> importantKeyPoints, 
			       List<String> highlightKeyPoints, List<ObjectId> modulesList) {
		super();
		this.courseTitle = courseTitle;
		this.courseDesc = courseDesc;
		this.courseLang = courseLang;
		this.importantKeyPoints = importantKeyPoints;
		this.highlightKeyPoints = highlightKeyPoints;
	}

	public ObjectId getId() {
		return id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getCourseLang() {
		return courseLang;
	}

	public void setCourseLang(String courseLang) {
		this.courseLang = courseLang;
	}

	public List<String> getImportantKeyPoints() {
		return importantKeyPoints;
	}

	public void setImportantKeyPoints(List<String> importantKeyPoints) {
		this.importantKeyPoints = importantKeyPoints;
	}

	public List<String> getHighlightKeyPoints() {
		return highlightKeyPoints;
	}

	public void setHighlightKeyPoints(List<String> highlightKeyPoints) {
		this.highlightKeyPoints = highlightKeyPoints;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public List<String> getModulesList() {
		return modulesList;
	}

	public void setModulesList(List<String> modulesList) {
		this.modulesList = modulesList;
	}

	public int getNumberOfStudentsRegistered() {
		return numberOfStudentsRegistered;
	}

	public void setNumberOfStudentsRegistered(int numberOfStudentsRegistered) {
		this.numberOfStudentsRegistered = numberOfStudentsRegistered;
	}

	public void incrementNumOfStudentsRegistered() {
		this.numberOfStudentsRegistered = this.numberOfStudentsRegistered+1;
	}

	public void includeModule(String moduleId) {
		this.modulesList.add(moduleId);
	}	
}
