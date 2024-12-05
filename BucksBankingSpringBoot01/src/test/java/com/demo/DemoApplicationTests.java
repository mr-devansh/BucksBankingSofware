package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.Account;
import com.demo.repository.AccountRepository;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	AccountRepository accountRepository;

	@Test
	void contextLoads() {
	}
//	@Test
//	void addAccount() {
//		Account dev = new Account("devansh", true, null, null, 26000, "A@gmail.com");
//
//		Account yash = new Account("yash", true, null, null, 26000, "A@gmail.com");
//
//		accountRepository.save(dev);
//		accountRepository.save(yash);
//	}
}
