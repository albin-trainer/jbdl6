package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;

@RestController
public class MyApi {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder encoder;
	@GetMapping("/hello")
	@PreAuthorize("hasRole('USER')")
	public String hello() {
		return "HELLO USER";
	}
	
	@GetMapping("/welcome")
	@PreAuthorize("hasRole('ADMIN')")
	public String welome() {
		return "Welcome ADMIN";
	}
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	
}
