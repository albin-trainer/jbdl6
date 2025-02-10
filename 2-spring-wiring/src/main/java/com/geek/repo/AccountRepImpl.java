package com.geek.repo;

public class AccountRepImpl  implements AccountRep{
	public AccountRepImpl() {
		System.out.println("constructor repo");
	}
	public String credit(float amt) {
		return "Hi the amt "+amt+"  salary credited in ur savings acc" ;
	}

}
