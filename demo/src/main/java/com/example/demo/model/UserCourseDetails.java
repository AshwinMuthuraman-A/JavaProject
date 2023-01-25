package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usercoursedetails")
public class UserCourseDetails {
	
	@Id
	private ObjectId id;
	
	private String userCourseDetailsId;
	private String courseId;
	private double courseCompletedPercentage;
	List<Boolean> modulesCompleted;
	
	public UserCourseDetails() {
		super();
		this.userCourseDetailsId = null;
		this.courseCompletedPercentage = 0;
		this.modulesCompleted = new ArrayList<Boolean>();
	}
	public ObjectId getId() {
		return id;
	}
	public String getUserCourseDetailsId() {
		return userCourseDetailsId;
	}
	public void setUserCourseDetailsId(String userCourseDetailsId) {
		this.userCourseDetailsId = userCourseDetailsId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public double getCourseCompletedPercentage() {
		return courseCompletedPercentage;
	}
	public void setCourseCompletedPercentage(double courseCompletedPercentage) {
		this.courseCompletedPercentage = courseCompletedPercentage;
	}
	public List<Boolean> getModulesCompleted() {
		return modulesCompleted;
	}
	public void setModulesCompleted(List<Boolean> modulesCompleted) {
		this.modulesCompleted = modulesCompleted;
	}
	public void updateCourseCompletedPercentage() {
		double trueCount = 0.0;
		for(Boolean b : this.modulesCompleted) {
			if(b==true)
				++trueCount;
		}
		double size = this.modulesCompleted.size();
		double newPercentage;
		if(size!=0)
			newPercentage = trueCount/size * 100;
		else
			newPercentage = 0.0;
		this.setCourseCompletedPercentage(newPercentage);
	}	
	
}
