package com.geek.repo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("cc")
public class CreditCardAccImpl implements AccountRep{
	public String credit(float amt) {
		// TODO Auto-generated method stub
		return "Hi ur credit card due "+amt+" is paid successfully !!!!!";
	}

}
