package com.geek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.geek.controller.AccController;
import com.geek.repo.AccountRep;
import com.geek.repo.CreditCardAccImpl;
import com.geek.repo.SavingsAccImpl;
import com.geek.service.AccountService;
import com.geek.service.AccountServiceImpl;
public class SpringConfig {
	@Bean//replacing <bean> in xml
public AccController getController() {
	return new AccController();
}
	@Bean
	public AccountService getService() {
		return new AccountServiceImpl();
	}
	@Bean
	public AccountRep getSavings() {
		return new SavingsAccImpl();
	}
	@Bean("cc")
	public AccountRep getCreditCard() {
		return new CreditCardAccImpl();
	}
}
