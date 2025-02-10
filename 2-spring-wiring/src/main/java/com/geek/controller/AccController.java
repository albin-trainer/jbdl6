package com.geek.controller;

import com.geek.service.AccountService;

public class AccController {
	private AccountService accService;
public AccController() {
	System.out.println("controller");
}
	public void setAccService(AccountService accService) {
		this.accService = accService;
		System.out.println("setter of controller");
	}
	
	public String credit(float amt) {
		return accService.creditFundsService(amt);
	}
}
