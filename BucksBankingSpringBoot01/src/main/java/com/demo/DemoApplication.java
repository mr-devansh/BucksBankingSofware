package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.demo.model.Account;
import com.demo.repository.AccountRepository;
import com.demo.service.AccountService;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	public static void main(String[] args) throws Exception {
		
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		AccountService accSer = context.getBean(AccountService.class);
		accSer.transfer(2L, 132L, 1000);
	}
}
