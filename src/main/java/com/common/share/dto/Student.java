package com.jntuh.college.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Student {
	private String firstName;
	private String latName;
	private String email;
	private String phoneNo;
	private String dob;
	private String newPassword;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLatName() {
		return latName;
	}
	public void setLatName(String latName) {
		this.latName = latName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
