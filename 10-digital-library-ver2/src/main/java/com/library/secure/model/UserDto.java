package com.library.secure.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDto {
	//@NotNull(message="username required")
	@NotBlank(message="Username req")
    private String userName;
    private String password;
    private String email;
    private int userId;
    private String role;

@Column(unique = true)
private int phoneNumber;
private String address;


    public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

	public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

	public int getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(int phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
