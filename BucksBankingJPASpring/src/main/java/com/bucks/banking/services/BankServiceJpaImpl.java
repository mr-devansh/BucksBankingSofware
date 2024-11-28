package com.bucks.banking.services;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bucks.banking.BankAppConfiguration;
import com.bucks.banking.model.Account;
import com.bucks.banking.model.Beneficiary;
import com.bucks.banking.repositories.AccountRepository;
import com.bucks.banking.repositories.RewardRepository;
import com.bucks.banking.repositories.TransactionRepository;

import jakarta.persistence.*;

public class BankServiceJpaImpl implements BankService{
	
	AccountRepository accountRepo;// 	=	context.getBean(AccountRepository.class);
	TransactionRepository transactionRepo;// = 	context.getBean(TransactionRepository.class);
	RewardRepository rewardRepo; 		//= 	context.getBean(RewardRepository.class);
	EmailService emailService; 	//= 	context.getBean(EmailService.class);
	BankService bankService; //= context.getBean(BankService.class);
	
	
	
	public BankServiceJpaImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void transfer(Long fromAccount, Long toAccount, int amount) {
		// TODO Auto-generated method stub
		bankService.debit(amount, fromAccount);
		bankService.credit(amount, toAccount);
		System.out.println("Transfer successful");
	}
	@Override
	public void credit(int amount, Long accountNumber) {
		Account acc = accountRepo.findAccountByNumber(accountNumber);
		if(acc!=null) {
			acc.setBalance(acc.getBalance()+amount);
			accountRepo.save(acc);
			System.out.println("credit successful");
		}
		else {
			System.out.println("Account not found");
		}
	}

	@Override
	public void debit(int amount, Long accountNumber) {
		// TODO Auto-generated method stub
		Account acc = accountRepo.findAccountByNumber(accountNumber);
		if(acc!=null) {
			if(acc.getBalance()>=amount) {
				acc.setBalance(acc.getBalance()-amount);
				accountRepo.save(acc);
				System.out.println("debit successful");

			}
			else {
				System.out.println("Insufficient");
			}
		}
		else {
			System.out.println("Account not found");
		}
	}

	@Override
	public void createNewAccount(Account account) {
		// TODO Auto-generated method stub
		accountRepo.save(account);
	}

	@Override
	public void deactivateAccount(Long accountNumber) {
		// TODO Auto-generated method stub

		Account acc = accountRepo.findAccountByNumber(accountNumber);
		acc.setActive(false);
		accountRepo.update(acc);
	}

	@Override
	public void activateAccount(Long accountNumber) {
		// TODO Auto-generated method stub
		Account acc = accountRepo.findAccountByNumber(accountNumber);
		acc.setActive(true);
		accountRepo.update(acc);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepo.findAllAccounts();
	}

	@Override
	public void updateBeneficiaries(String[] split, long account) {
		// TODO Auto-generated method stub
		Set<Beneficiary> sett = new HashSet<>();
		for(String e : split) {
			sett.add(new Beneficiary(e));
		}
		Account acc = accountRepo.findAccountByNumber(account);
		if(acc!=null) {
			acc.setBeneficiaries(sett);
			System.out.println("Beneficiaries added");
		}
		else {
			System.out.println("Account not found");
		}
	}


}