package com.banking.mapper;

import com.banking.entity.AccountEntity;
import com.banking.model.Account;

public class AccountMapper {

	public static AccountEntity mapToAccountEntity(Account account) {
		
		AccountEntity accountEntity = new AccountEntity(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				);
		
		return accountEntity;
		
	}	
	
	public static Account mapToAccount(AccountEntity accountEntity) {
		
		Account account = new Account(
				accountEntity.getId(),
				accountEntity.getAccountHolderName(),
				accountEntity.getBalance()
				);
		return account;
	}
	
	
}
