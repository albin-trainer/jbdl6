package com.geek.service;

import com.geek.repo.AccountRep;

public class AccountServiceImpl implements AccountService{
	private AccountRep rep;
	public AccountServiceImpl() {
		System.out.println("service constructor");
	}
	public void setRep(AccountRep rep) {
		this.rep = rep;
		System.out.println("service setter");
	}

	public String creditFundsService(float amt) {
		return rep.credit(amt);
	}
}
