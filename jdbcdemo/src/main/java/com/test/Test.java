package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dnb.jdbcdemo.config.Config;
import com.dnb.jdbcdemo.service.AccountService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

		//List<String> result = applicationContext.getBean("arrayDemo", List.class);
		
		//result.forEach(e->System.out.println(e));
		
		AccountService accountService = (AccountService) applicationContext.getBean("accountServiceImpl");
		System.out.println(accountService!=null);
	}

}
