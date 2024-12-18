package com.bucks.banking.repositories;

import java.sql.Connection;
import java.util.List;

import com.bucks.banking.model.Account;

import jakarta.persistence.*;

public class JpaAccountRepositoryImpl implements AccountRepository{
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("BucksBanking");
	EntityManager manager = factory.createEntityManager();
	@Override
	public Account findAccountByNumber(Long accountNumber) {
		Account acc = manager.find(Account.class,accountNumber);
		return acc;
	}

	@Override
	public List<Account> findAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long save(Account account) {
		manager.getTransaction().begin();
		manager.persist(account);//inserts because object of type java employee
		manager.getTransaction().commit();
		return 1;
	}

	@Override
	public void update(Account account, Connection connection) {
		// TODO Auto-generated method stub
		Account found = manager.find(Account.class, account.getAccountNumber());
		if(found!=null) {
			found = account;
			manager.getTransaction().begin();
			manager.persist(found);//inserts because object of type java employee
			manager.getTransaction().commit();
		}
	}

	@Override
	public void delete(Account account) {
		// TODO Auto-generated method stub
		Account acc = manager.find(Account.class, account.getAccountNumber());
		if(acc!=null) {
			manager.getTransaction().begin();
			manager.remove(acc);
			manager.getTransaction().commit();
		}
	}
}
