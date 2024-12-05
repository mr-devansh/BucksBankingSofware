package com.demo.service;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.RollbackOn;

import com.demo.model.Account;
import com.demo.repository.AccountRepository;

import jakarta.transaction.Transactional;


@Service
public class AccountService {
	AccountRepository accountrepository;

	public AccountService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public AccountService(AccountRepository accountrepository) {
		this.accountrepository =  accountrepository;
	}

	public boolean debit(Long accNo, int amount) throws Exception {
		try {
			Optional<Account> accFound = accountrepository.findById(accNo);
			if(accFound.isPresent()) {
				Account foundAcc  = accFound.get();
				if(foundAcc.getBalance()>=amount) {
					foundAcc.setBalance(foundAcc.getBalance()-amount);
					accountrepository.save(foundAcc);
					return true;
				}
				else {
					throw new Exception();
				}
			}
			else {
				throw new Exception();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
		return false;
	}
	public boolean credit(Long accNo, int amount) throws Exception {
		try {
			Optional<Account> accFound = accountrepository.findById(accNo);
			if(accFound.isPresent()) {
				Account FoundAcc = accFound.get();
				FoundAcc.setBalance(FoundAcc.getBalance()+amount);
				accountrepository.save(FoundAcc);
				return true;
			}else {
				throw new Exception();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
		return false;
	}
	
    public void transfer(Long sender, Long receiver, int amount) throws Exception {
        debit(sender, amount);
        credit(receiver, amount);
	}
}
