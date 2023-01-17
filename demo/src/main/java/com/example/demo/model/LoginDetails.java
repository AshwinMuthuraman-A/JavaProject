package com.example.demo.model;


public class LoginDetails {
	private String loginEmail;
	private String loginPassword;
	
	public LoginDetails() {
		super();
	}
	
	public LoginDetails(String loginEmail, String loginPassword) {
		super();
		this.loginEmail = loginEmail;
		this.loginPassword = loginPassword;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
}
