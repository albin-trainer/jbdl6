package com.geek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProducerApi {
	@Autowired
	private MessageService messageService;
	@PostMapping("/msg")
	public String sendMessage(@RequestBody  Message msg) {
		messageService.sendMsg(msg);
		return "Msg send";
	}
}
