package com.geek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	@Autowired
	private KafkaTemplate<String, String> template;
	public void sendMsg(Message msg) {
		template.send("jbdl6topic", msg.getUsr(), msg.getMsg());
		System.out.println("msg send ....");
	}
}
