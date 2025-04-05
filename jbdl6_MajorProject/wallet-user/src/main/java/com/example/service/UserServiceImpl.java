package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Value("${wallet.promo.amt}")
 private float promoAmt;
	@Autowired
	private UserRepository userRepo;
public User registerUser(User user) {
	user.setAmount(promoAmt);
	return userRepo.save(user);
}
@Autowired
private Environment env;
public UserDto getUserById(int id) {
	User user= userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
	UserDto dto= new UserDto();
	BeanUtils.copyProperties(user, dto);
	String port=env.getProperty("local.server.port");
	dto.setPort(port);
	return dto;
}
}
