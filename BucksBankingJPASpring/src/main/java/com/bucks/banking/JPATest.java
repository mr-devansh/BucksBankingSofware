package com.bucks.banking;

import java.util.*;

import com.bucks.banking.model.Account;
import com.bucks.banking.model.Address;
import com.bucks.banking.model.Beneficiary;
import com.bucks.banking.repositories.JpaAccountRepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPATest {
	
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BucksBanking");
		EntityManager manager = factory.createEntityManager();
		
		
		
		JpaAccountRepositoryImpl JPAAccountImpl = new JpaAccountRepositoryImpl();
		Set<Beneficiary> bene = new HashSet<Beneficiary>();
		bene.add(new Beneficiary(1001, "ABC"));
		Address add = new Address("City", "Country");
		Account acc = new Account("Devansh", true, bene, add, 20000, "Tets@gmail.com");
		
		JPAAccountImpl.save(acc);
//		System.out.println(JPAAccountImpl.findAccountByNumber(acc.getAccountNumber()));
	}
}
