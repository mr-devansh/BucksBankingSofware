package com.bucks.banking;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bucks.banking.repositories.AccountRepository;
import com.bucks.banking.repositories.RewardRepository;
import com.bucks.banking.repositories.TransactionRepository;
import com.bucks.banking.services.BankService;
import com.bucks.banking.services.EmailService;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

		
		BankService bankService = context.getBean(BankService.class);
		System.out.println(bankService.transfer(51L, 33L, 300));

	}

}
