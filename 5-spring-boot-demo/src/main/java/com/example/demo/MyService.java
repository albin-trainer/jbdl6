package com.example.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class MyService {
public MyService( @Value("${wish}") String s) {
	System.out.println("My service constructor ...." +s);
}
}
