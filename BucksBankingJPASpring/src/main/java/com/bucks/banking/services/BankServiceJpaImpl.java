package com.bucks.banking.services;

import java.sql.Connection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bucks.banking.BankAppConfiguration;
import com.bucks.banking.model.Account;
import com.bucks.banking.model.Beneficiary;
import com.bucks.banking.model.TransactionDetail;
import com.bucks.banking.model.TransactionType;
import com.bucks.banking.repositories.AccountRepository;
import com.bucks.banking.repositories.RewardRepository;
import com.bucks.banking.repositories.TransactionRepository;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

public class BankServiceJpaImpl implements BankService{
	ApplicationContext context = new AnnotationConfigApplicationContext(BankAppConfiguration.class);
	AccountRepository accountRepo;
	TransactionRepository transactionRepo;
	RewardRepository rewardRepo;
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("BucksBanking");
	EntityManager manager = factory.createEntityManager();

	public BankServiceJpaImpl() {
		super();
		accountRepo=	context.getBean(AccountRepository.class);
		transactionRepo = 	context.getBean(TransactionRepository.class);
		rewardRepo= 	context.getBean(RewardRepository.class);
	}
	@Override
	@Transactional
	public void transfer(Long fromAccount, Long toAccount, int amount) {
		// TODO Auto-generated method stub
		try {

			debit(amount, fromAccount);
			credit(amount, toAccount);
			System.out.println("Transfer successful");

		} catch (Exception e) {
			// Logging the exception here if needed

			System.out.println("Error during transfer: " + e.getMessage());
			throw e; // Spring will automatically rollback the transaction if an exception is thrown
		}
	}
	@Override
	public void credit(int amount, Long accountNumber) {
		
			Account acc = accountRepo.findAccountByNumber(accountNumber);

			if(acc!=null) {

				acc.setBalance(acc.getBalance()+amount);
				accountRepo.update(acc);
				transactionRepo.addTransaction(new TransactionDetail(accountNumber, new Date(), amount, TransactionType.CREDIT));

				System.out.println("credit successful");

			}
			else {
			throw new RuntimeException("Account not found for credit operation.");
		}
		
	}

	@Override
	public void debit(int amount, Long accountNumber) {
		// TODO Auto-generated method stub
		Account acc = accountRepo.findAccountByNumber(accountNumber);
		if(acc!=null) {

				if(acc.getBalance()>=amount) {

					acc.setBalance(acc.getBalance()-amount);
					accountRepo.update(acc);
					transactionRepo.addTransaction(new TransactionDetail(accountNumber, new Date(), amount, TransactionType.DEBIT));
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
		System.out.println("Account created");
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
