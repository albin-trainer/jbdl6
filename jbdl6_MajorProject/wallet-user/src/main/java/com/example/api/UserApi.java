package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserApi {
	@Autowired
private UserService userService;
	Logger log=LoggerFactory.getLogger(UserApi.class);

	@PostMapping("/register")
	public User registerUser(@RequestBody  User user) {
	return	userService.registerUser(user);
	}
	@GetMapping("/{id}")
	public UserDto searchById(@PathVariable("id")  int userId) {
		log.info("Searching ById from {} ",userId);

		return	userService.getUserById(userId);
		}
}
