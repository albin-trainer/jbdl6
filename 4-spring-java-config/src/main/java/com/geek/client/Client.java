package com.geek.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geek.config.SpringConfig;
import com.geek.controller.AccController;
public class Client {
public static void main(String[] args) {
	ApplicationContext ctx=
	new AnnotationConfigApplicationContext(SpringConfig.class);
	//AccController ctrler=  (AccController) ctx.getBean("contrller");
	AccController ctrler=ctx.getBean(AccController.class);
	System.out.println(ctrler.credit(50000));
}
}
