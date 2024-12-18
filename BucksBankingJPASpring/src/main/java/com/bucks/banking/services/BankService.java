package com.bucks.banking.services;

import com.bucks.banking.model.Account;

import java.sql.Connection;
import java.util.List;

public interface BankService {

    void transfer(Long fromAccount, Long toAccount, int amount);

    void debit(int amount, Long accountNumber);

    void credit(int amount, Long accountNumber);

    void createNewAccount(Account account);

    void deactivateAccount(Long accountNumber);

    void activateAccount(Long accountNumber);

    List<Account> getAllAccounts();

	void updateBeneficiaries(String[] split, long account);
}
