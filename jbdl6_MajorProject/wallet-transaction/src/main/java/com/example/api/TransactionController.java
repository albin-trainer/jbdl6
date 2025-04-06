package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private TransactionService service;
	Logger log=LoggerFactory.getLogger(TransactionController.class);

	@GetMapping("/{userId}")
	public UserDto getBalance(@PathVariable("userId")  int userId) {
		log.info("getting balance from {} ",userId);
		return service.getBalance(userId);
	}
}
