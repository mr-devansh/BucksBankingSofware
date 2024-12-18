package com.bucks.banking;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.*;

import com.bucks.banking.repositories.AccountRepository;
import com.bucks.banking.repositories.JpaAccountRepositoryImpl;
import com.bucks.banking.repositories.JpaRewardRepositoryImpl;
import com.bucks.banking.repositories.JpaTransactionRepositoryImpl;
import com.bucks.banking.repositories.RewardRepository;
import com.bucks.banking.repositories.TransactionRepository;
import com.bucks.banking.services.BankService;
import com.bucks.banking.services.BankServiceJpaImpl;
import com.bucks.banking.services.EmailService;

import jakarta.persistence.*;

@Configuration
public class BankAppConfiguration {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("BucksBanking");
	EntityManager manager = factory.createEntityManager();

	//make factory manager bean
	@Bean
	public BasicDataSource createDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername("postgres");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/BucksBanking");
		return dataSource;
	}
	@Bean
	public AccountRepository createAccountRepositry() {
		return new JpaAccountRepositoryImpl(factory, manager);
	}
	@Bean
	public RewardRepository createRewardRepositry() {
		return new JpaRewardRepositoryImpl(factory, manager);
	}
	@Bean
	public TransactionRepository createTransactionRepositry() {
		return new JpaTransactionRepositoryImpl(factory, manager);
	}
}
