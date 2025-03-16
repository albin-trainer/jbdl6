package com.example.demo.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyApi {
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
	
	@GetMapping("/hi")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public String helloAll() {
		return "Welcome USERS";
	}
}
