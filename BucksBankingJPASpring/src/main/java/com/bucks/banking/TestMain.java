package com.bucks.banking;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bucks.banking.model.Account;
import com.bucks.banking.model.Address;
import com.bucks.banking.model.Beneficiary;
import com.bucks.banking.model.Reward;
import com.bucks.banking.model.TransactionDetail;
import com.bucks.banking.model.TransactionType;
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
		BankService bankService = new BankServiceJpaImpl();
		
//		Set<Beneficiary> bene = new HashSet<Beneficiary>();
//		bene.add(new Beneficiary("ABC"));
//		Address add = new Address("City", "Country");
//		
//		Set<Beneficiary> bene2 = new HashSet<Beneficiary>();
//		bene2.add(new Beneficiary("ABC"));
//		bene2.add(new Beneficiary("ABC"));
//		Address add2 = new Address("City", "Country");
//		
//		Account acc = new Account("Devansh", true, bene, add, 20000, "Tets@gmail.com");
//		Account acc2 = new Account("Ansh", true, bene2, add2, 20400, "Tetff@gmail.com");
//
//		bankService.createNewAccount(acc);;
//		bankService.createNewAccount(acc2);
//
//		
//		System.out.println(bankService.getAllAccounts());

//		JPARewardImpl.addReward(new Reward(100, 1));
//		JPARewardImpl.addReward(new Reward(50, 1));
//		
//		System.out.println(JPARewardImpl.getTotalRewardAmount(1L));
//		
//		System.out.println(JPARewardImpl.getAllRewardsForAccount(1L));
//
//		JPATransactionImpl.addTransaction(new TransactionDetail(1L, new Date(), 1000, TransactionType.CREDIT));
//		JPATransactionImpl.addTransaction(new TransactionDetail(2L, new Date(), 800, TransactionType.DEBIT));
//		JPATransactionImpl.addTransaction(new TransactionDetail(1L, new Date(), 500, TransactionType.DEBIT));
//
//		System.out.println(JPATransactionImpl.getAllTransactionDetailsByAccountNumber(1L));
//	
		
		bankService.transfer(1L,4L,3);
	}

}
