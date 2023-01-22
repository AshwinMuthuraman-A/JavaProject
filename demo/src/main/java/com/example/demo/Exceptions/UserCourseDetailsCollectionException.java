package com.example.demo.Exceptions;

public class UserCourseDetailsCollectionException extends Exception{
	private static final long serialVersionUID = 1L;

	public UserCourseDetailsCollectionException(String expMsg) {
		super(expMsg);
	}
	
	public static String UCDetailsNotFound() {
		return "UCDetails Not Found!";
	}
}
