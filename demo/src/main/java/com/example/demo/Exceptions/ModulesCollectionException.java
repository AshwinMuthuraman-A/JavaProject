package com.example.demo.Exceptions;

public class ModulesCollectionException extends Exception {
	private static final long serialVersionUID = 1L;

	public ModulesCollectionException(String expMsg) {
		super(expMsg);
	}

	public static String ModulesNotFound() {
		return "Module not found!";
	}
}