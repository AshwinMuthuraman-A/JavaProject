package com.example.demo.Exceptions;

public class UserCollectionException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserCollectionException(String expMsg) {
		super(expMsg);
	}
	
	public static String EmailAlreadyExists() {
		return "Email ID already exist, kindly login";
	}

	public static String EmailNotExists() {
		return "Email ID does not exist, kindly signup";
	}

	public static String PasswordNotMatching() {
		return "Password does not match, try again";
	}
}
