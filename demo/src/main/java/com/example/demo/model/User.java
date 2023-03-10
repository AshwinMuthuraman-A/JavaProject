package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document(collection = "user")
public class User {
	
		@Id
		private ObjectId id;
		
		private String userId;
		
		@NotNull(message = "User Name cannot be null")
		private String userName;
		
		@NotNull(message = "User Email cannot be null")
		private String userEmail;

		@NotNull(message= "User Password cannot be null")
		private String userPassword;
		
		@NotNull(message="User Type cannot be null")
		private String userType;
		
		private List<String> courseList;		
		
		public User() {
			super();
			this.userId = null;
			this.courseList = new ArrayList<String>();
		}

		public User(@NotNull(message = "User Name cannot be null") String userName,
				@NotNull(message = "User Email cannot be null") String userEmail,
				@NotNull(message = "User Password cannot be null") String userPassword,
				@NotNull(message = "User Type cannot be null") String userType) {
			super();
			this.userName = userName;
			this.userEmail = userEmail;
			this.userPassword = userPassword;
			this.userType = userType;
		}

		public ObjectId getId() {
			return id;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}

		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

		public List<String> getCourseList() {
			return courseList;
		}

		public void setCourseList(List<String> courseList) {
			this.courseList = courseList;
		}

		public void addCourse(String courseId) {
			this.courseList.add(courseId);
		}
		
}
