package com.bucks.banking.repositories;

import java.sql.Connection;
import java.util.List;

import com.bucks.banking.model.Account;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

public class JpaAccountRepositoryImpl implements AccountRepository{
	EntityManagerFactory factory;
	EntityManager manager;
	public JpaAccountRepositoryImpl(EntityManagerFactory factory, EntityManager manager) {
		super();
		this.factory = factory;
		this.manager = manager;
	}

	
	@Override
	public Account findAccountByNumber(Long accountNumber) {
		Account acc = manager.find(Account.class,accountNumber);
		return acc;
	}

	@Override
	public List<Account> findAllAccounts() {
	    // Create a JPQL query to find all Account entities
	    TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a", Account.class);
	    
	    // Execute the query and return the result list
	    return query.getResultList();
	}

	@Override
	public void save(Account account) {
		try {
            manager.persist(account.getAddress());
            account.getBeneficiaries().forEach(manager::persist);
            manager.persist(account);

        } catch (Exception e) {
            // Handling exceptions if needed
            throw new RuntimeException("Error saving account", e);
        }
	}

	@Override

	public void update(Account account) {
		Account found = manager.find(Account.class, account.getAccountNumber());
        if (found != null) {

            manager.merge(account); // Update the account

        } else {

            throw new RuntimeException("Account not found for update.");
        }
	}

	@Override
	public void delete(Account account) {
		// TODO Auto-generated method stub
		Account acc = manager.find(Account.class, account.getAccountNumber());
		if(acc!=null) {
			manager.remove(acc);
		}
	}
}
