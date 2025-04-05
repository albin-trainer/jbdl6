package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;

public interface UserService {
	public User registerUser(User user);
	public UserDto getUserById(int id) ;
}
