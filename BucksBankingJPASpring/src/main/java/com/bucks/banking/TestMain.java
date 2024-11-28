package com.bucks.banking;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bucks.banking.repositories.AccountRepository;
import com.bucks.banking.repositories.RewardRepository;
import com.bucks.banking.repositories.TransactionRepository;
import com.bucks.banking.services.BankService;
import com.bucks.banking.services.BankServiceJpaImpl;
import com.bucks.banking.services.EmailService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(BankAppConfiguration.class);
		AccountRepository accountRepo 	=	context.getBean(AccountRepository.class);
		TransactionRepository transactionRepo = 	context.getBean(TransactionRepository.class);
		RewardRepository rewardRepo 		= 	context.getBean(RewardRepository.class);
		BankService bankService = new BankServiceJpaImpl();
		bankService.transfer(51L, 33L, 300);

	}

}
