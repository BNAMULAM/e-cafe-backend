package com.example.cafe.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class LoginDTO {
	
	private String userName;
	@Size(min = 4, max = 10,message="Password length should be between 4 to 10")
	private String password;
	@Length(min = 10,max=10,message="Please enter valid Mobile number")
	private String mobileNumber;
	private Role role;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public LoginDTO() {
		super();
	}
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + ", mobileNumber="
				+ mobileNumber + "]";
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
