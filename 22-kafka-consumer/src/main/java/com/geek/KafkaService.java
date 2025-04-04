package com.geek;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class KafkaService {
	 @KafkaListener( topics =  {"jbdl6topic"},groupId = "group-id")
	 //this function will get called automatically once msg received
	 //in the topic .....
	public void consumeMessages(ConsumerRecord<String, String> consumer) {
		 String key=consumer.key();
		 String value=consumer.value();
		 long timeStamp=  consumer.timestamp();
		 Date date=new Date(timeStamp);
		 System.out.println(key+"  "+value+" received @ "+date);
	}

}
