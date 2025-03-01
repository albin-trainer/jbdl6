package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//@SpringBootConfiguration +@EnableAutoConfiguration+@ComponentScan
//@ComponentScan(basePackages = "com")
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		   //initialize Spring container
		   //scans the classpath
		   //create the components
	}

}
