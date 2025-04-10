package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WalletTransactionApplication {
	public static void main(String[] args) {
		SpringApplication.run(WalletTransactionApplication.class, args);
	}
    @Bean
     @LoadBalanced
     public RestTemplate getTemplate(RestTemplateBuilder builder) {
 		return builder.build();
 	}
//	public RestTemplate getTemplate() {
//		return new RestTemplate();
//	}
}
