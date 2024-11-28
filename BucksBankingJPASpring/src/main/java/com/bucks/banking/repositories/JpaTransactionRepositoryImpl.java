package com.bucks.banking.repositories;

import java.sql.Connection;
import java.util.List;

import com.bucks.banking.model.Reward;
import com.bucks.banking.model.TransactionDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class JpaTransactionRepositoryImpl implements TransactionRepository {
	EntityManagerFactory factory;
	EntityManager manager;
	
	
	
	public JpaTransactionRepositoryImpl(EntityManagerFactory factory, EntityManager manager) {
		super();
		this.factory = factory;
		this.manager = manager;
	}

	@Override
	public Long addTransaction(TransactionDetail transactionDetail) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(transactionDetail);
		manager.getTransaction().commit();
		return 1L;
		
	}

	@Override
	public List<TransactionDetail> getAllTransactionDetailsByAccountNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		TypedQuery<TransactionDetail> query = manager.createQuery("SELECT a FROM TransactionDetail a", TransactionDetail.class);
	    
	    // Execute the query and return the result list
	    return query.getResultList();
	}

}
