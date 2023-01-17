package com.example.demo.Exceptions;

public class StudentCollectionException extends Exception {
	private static final long serialVersionUID = 1L;

	public StudentCollectionException(String expMsg) {
		super(expMsg);
	}
	
	public static String EmailAlreadyExists() {
		return "Email ID already exist";
	}
	
}
