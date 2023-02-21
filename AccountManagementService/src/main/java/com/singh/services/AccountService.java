package com.singh.services;

import java.util.Optional;

import com.singh.entities.Account;

public interface AccountService {
	
	Account createAccount(Account account);
	
	Object addMoney(Account account);
	
	Object withdrawMoney(Account account);
	
	Account getAccount(String accountId);
	
	void deleteAccount(String accountId);

}
