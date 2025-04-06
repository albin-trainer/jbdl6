package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.constants.AppConstants;
import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repo.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class UserServiceImpl implements UserService {
	@Value("${wallet.promo.amt}")
 private float promoAmt;
	@Autowired
	private UserRepository userRepo;
public User registerUser(User user) {
	UserDto userDto=new UserDto();
	user.setAmount(promoAmt);
	user= userRepo.save(user);
		BeanUtils.copyProperties(user, userDto);

		sendNotification(userDto);
		return user;
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
@Autowired
private KafkaTemplate<String, String> kafkaTemplate;
@Autowired
private ObjectMapper mapper;
private void sendNotification(UserDto userDto) {
//	ObjectMapper mapper=new ObjectMapper();
	try {
	String json=mapper.writeValueAsString(userDto);
	System.out.println(json);
	kafkaTemplate.send(AppConstants.NEW_USER,userDto.getUserName(), json);
	System.out.println("Msg send ....");
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
}
}
