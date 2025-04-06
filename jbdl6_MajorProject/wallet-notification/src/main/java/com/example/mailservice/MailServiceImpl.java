package com.example.mailservice;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.constants.AppConstants;
import com.example.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class MailServiceImpl  implements MailService{
	@Autowired
	private SimpleMailMessage simpleMailMessage;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private ObjectMapper mapper;
	@KafkaListener(topics = AppConstants.NEW_USER,groupId = "group-id")
	@Override
	public void sendAndReceiveMsg(ConsumerRecord<String, String> record) {
		String k=record.key();
		String json=record.value();
		 System.out.println("RECEIVED : "+json);

			try {
				UserDto user= mapper.readValue(json, UserDto.class);
				simpleMailMessage.setTo(user.getEmail());
				simpleMailMessage.setSubject("Succesfully Registered .....");
					//simpleMailMsg.setFrom("albinxavier@gmail.com");
				simpleMailMessage.setText("Hi "+user.getUserName()+" Congrats u have created ur wallet account");
				mailSender.send(simpleMailMessage);
					System.out.println("SENd...");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
	}

}
