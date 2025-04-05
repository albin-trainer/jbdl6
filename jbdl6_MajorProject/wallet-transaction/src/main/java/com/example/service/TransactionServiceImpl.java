package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.UserDto;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public UserDto getBalance(int uid) {
		//here it has to call user service (another ms)
		//String url="http://localhost:8001/users/"+uid;
	//	RestTemplate restTemplate= new RestTemplate();
		String url="http://wallet-user/users/"+uid;
		UserDto  userDto=restTemplate.getForObject(url, UserDto.class);
		return userDto;
	}

}
