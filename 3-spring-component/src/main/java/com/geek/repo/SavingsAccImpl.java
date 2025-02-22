package com.geek.repo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SavingsAccImpl  implements AccountRep{
	public SavingsAccImpl() {
		System.out.println("constructor repo");
	}
	public String credit(float amt) {
		return "Hi the amt "+amt+"  salary credited in ur savings acc" ;
	}

}
