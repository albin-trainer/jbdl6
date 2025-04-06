package com.example.mailservice;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface MailService {
public void sendAndReceiveMsg(ConsumerRecord<String, String> record );
}
