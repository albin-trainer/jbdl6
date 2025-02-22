package com.geek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.geek.repo.AccountRep;

public class AccountServiceImpl implements AccountService{
	@Autowired
	@Qualifier("cc")
	private AccountRep rep;
	public AccountServiceImpl() {
		System.out.println("service constructor");
	}
	
	public String creditFundsService(float amt) {
		return rep.credit(amt);
	}
}
