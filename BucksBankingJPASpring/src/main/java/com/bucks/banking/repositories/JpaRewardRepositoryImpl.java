package com.bucks.banking.repositories;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bucks.banking.model.Account;
import com.bucks.banking.model.Reward;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class JpaRewardRepositoryImpl implements RewardRepository{
	EntityManagerFactory factory;
	EntityManager manager;
	
	public JpaRewardRepositoryImpl(EntityManagerFactory factory, EntityManager manager) {
		super();
		this.factory = factory;
		this.manager = manager;
	}

	@Override
	public void addReward(Reward reward) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(reward);
		manager.getTransaction().commit();
	}

	@Override
	public int getTotalRewardAmount(Long accountNumber) {
		// TODO Auto-generated method stub
		TypedQuery<Reward> query = manager.createQuery("SELECT a FROM Reward a", Reward.class);
	    
	    // Execute the query and return the result list
	    return query.getResultList().stream().collect(Collectors.summingInt(Reward::getRewardAmount));
	}

	@Override
	public List<Reward> getAllRewardsForAccount(Long accountNumber) {
		// TODO Auto-generated method stub
		TypedQuery<Reward> query = manager.createQuery("SELECT a FROM Reward a", Reward.class);
	    
	    // Execute the query and return the result list
	    return query.getResultList();
	}

}
