package com.geek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geek.service.AccountService;

public class AccController {
	@Autowired
	private AccountService accService;
public AccController() {
	System.out.println("controller");
}
//@Autowired
//	public void setAccService(AccountService accService) {
//		this.accService = accService;
//		System.out.println("setter of controller");
//	}
//	
	public String credit(float amt) {
		return accService.creditFundsService(amt);
	}
}
