package com.example.demo.Exceptions;

public class CoursesCollectionException extends Exception {
	private static final long serialVersionUID = 1L;

	public CoursesCollectionException(String expMsg) {
		super(expMsg);
	}

	public static String CoursesNotFound() {
		return "Course not found!";
	}
}
