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
		
		@NotNull(message = "User Name cannot be null")
		private String userName;
		
		@NotNull(message = "User Email cannot be null")
		private String userEmail;

		@NotNull(message= "User Password cannot be null")
		private String userPassword;
		
		private List<ObjectId> courseList;		
		
		public User() {
			super();
		}

		public User(@NotNull(message = "User Name cannot be null") String userName,
				@NotNull(message = "User Email cannot be null") String userEmail,
				@NotNull(message = "User Password annot be null") String userPassword) {
			super();
			this.userName = userName;
			this.userEmail = userEmail;
			this.userPassword = userPassword;
			this.courseList = new ArrayList<>();
		}

		public ObjectId getId() {
			return id;
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

		public List<ObjectId> getCourseList() {
			return courseList;
		}

		public void setCourseList(List<ObjectId> courseList) {
			this.courseList = courseList;
		}		
}