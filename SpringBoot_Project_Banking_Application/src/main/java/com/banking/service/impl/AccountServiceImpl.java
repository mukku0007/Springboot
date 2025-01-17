package com.banking.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banking.entity.AccountEntity;
import com.banking.mapper.AccountMapper;
import com.banking.model.Account;
import com.banking.repository.AccountRepository;
import com.banking.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {

		AccountEntity accountEntity = AccountMapper.mapToAccountEntity(account);
		AccountEntity savedAccount = accountRepository.save(accountEntity);

		return AccountMapper.mapToAccount(savedAccount);

	}

	@Override
	public Account getAccountById(Long id) {
		AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't Exits"));
		return AccountMapper.mapToAccount(accountEntity);
	}

	@Override
	public Account deposit(Long id, double amount) {
		AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't Exits"));
		double totalBalance = accountEntity.getBalance() + amount;
		accountEntity.setBalance(totalBalance);
		AccountEntity savedAccountEntity = accountRepository.save(accountEntity);
		return AccountMapper.mapToAccount(savedAccountEntity);
	}

	@Override
	public Account withdraw(Long id, double amount) {
		
		AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't Exits"));
		
		if(accountEntity.getBalance() < amount) {
			throw new RuntimeException("InSufficient Balance");
		} 
		
		Double toatlBalance = accountEntity.getBalance() - amount;
		accountEntity.setBalance(toatlBalance);
		
		AccountEntity savedAccount = accountRepository.save(accountEntity);
		
		return AccountMapper.mapToAccount(savedAccount);
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> allAccounts = accountRepository.findAll().stream().map((account) -> AccountMapper.mapToAccount(account))
				.collect(Collectors.toList());
		
		return allAccounts;
	}

	@Override
	public Account deleteAccountById(Long id) {
		AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't Exits"));
		accountRepository.deleteById(id);
		return AccountMapper.mapToAccount(accountEntity);
	}

}
