package com.banking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.model.Account;

@Service
public interface AccountService {

	Account createAccount(Account account);
	
	Account getAccountById(Long id);
	
	Account deposit(Long id, double amount);
	
	Account withdraw(Long id, double amount);
	
	List<Account> getAllAccount();
	
	Account deleteAccountById(Long id);
}
