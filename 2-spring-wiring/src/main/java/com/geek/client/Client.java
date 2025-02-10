package com.geek.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geek.controller.AccController;

public class Client {
public static void main(String[] args) {
	ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
	//AccController ctrler=  (AccController) ctx.getBean("contrller");
	AccController ctrler=ctx.getBean(AccController.class);
	System.out.println(ctrler.credit(50000));
}
}
