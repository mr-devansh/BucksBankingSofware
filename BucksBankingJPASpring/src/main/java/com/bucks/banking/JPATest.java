package com.bucks.banking;

import java.util.*;

import com.bucks.banking.model.Account;
import com.bucks.banking.model.Address;
import com.bucks.banking.model.Beneficiary;
import com.bucks.banking.model.Reward;
import com.bucks.banking.model.TransactionDetail;
import com.bucks.banking.model.TransactionType;
import com.bucks.banking.repositories.JpaAccountRepositoryImpl;
import com.bucks.banking.repositories.JpaRewardRepositoryImpl;
import com.bucks.banking.repositories.JpaTransactionRepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPATest {
	
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BucksBanking");
		EntityManager manager = factory.createEntityManager();
		
		JpaAccountRepositoryImpl JPAAccountImpl = new JpaAccountRepositoryImpl(factory, manager);
		JpaRewardRepositoryImpl JPARewardImpl = new JpaRewardRepositoryImpl(factory, manager);
		JpaTransactionRepositoryImpl JPATransactionImpl = new JpaTransactionRepositoryImpl(factory, manager);

		Set<Beneficiary> bene = new HashSet<Beneficiary>();
		bene.add(new Beneficiary("ABC"));
		Address add = new Address("City", "Country");
		
		Set<Beneficiary> bene2 = new HashSet<Beneficiary>();
		bene2.add(new Beneficiary("ABC"));
		bene2.add(new Beneficiary("ABC"));
		Address add2 = new Address("City", "Country");
		
		Account acc = new Account("Devansh", true, bene, add, 20000, "Tets@gmail.com");
		Account acc2 = new Account("Ansh", true, bene2, add2, 20400, "Tetff@gmail.com");

		JPAAccountImpl.save(acc);
		JPAAccountImpl.save(acc2);

		
		System.out.println(JPAAccountImpl.findAccountByNumber(acc.getAccountNumber()));
		
		System.out.println(JPAAccountImpl.findAllAccounts());

		JPARewardImpl.addReward(new Reward(100, 1));
		JPARewardImpl.addReward(new Reward(50, 1));
		
		System.out.println(JPARewardImpl.getTotalRewardAmount(1L));
		
		System.out.println(JPARewardImpl.getAllRewardsForAccount(1L));

		JPATransactionImpl.addTransaction(new TransactionDetail(1L, new Date(), 1000, TransactionType.CREDIT));
		JPATransactionImpl.addTransaction(new TransactionDetail(2L, new Date(), 800, TransactionType.DEBIT));
		JPATransactionImpl.addTransaction(new TransactionDetail(1L, new Date(), 500, TransactionType.DEBIT));

		System.out.println(JPATransactionImpl.getAllTransactionDetailsByAccountNumber(1L));
	}
}
