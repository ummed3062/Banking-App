package com.singh.services.impl;

import java.io.Console;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.singh.entities.Account;
import com.singh.entities.Customer;
import com.singh.exceptions.ResourceNotFoundException;
import com.singh.repositories.AccountRepository;
import com.singh.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	

	@Override
	public Account createAccount(Account account) {
//		String randomAccountId = UUID.randomUUID().toString();
//		account.setAccountId(randomAccountId);
		Account accountCreated = accountRepo.save(account);
		return accountCreated;
	}
	
	@Override
	public Object addMoney(Account account) {

		String accountId = account.getAccountId();
		Customer customer = restTemplate.getForObject("http://CUSTOMER-MANAGEMENT-SERVICE/customer/"+accountId, Customer.class);
		
		Account updateAccount = this.accountRepo.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Account with given id is not found "+ accountId));
		
		if (customer.getAccountNumber().equals(account.getAccountNumber())) {
			int updatedAmount = account.getMoney()+updateAccount.getMoney();
			updateAccount.setMoney(updatedAmount);	
		}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Number is mismatch with given id" + account.getAccountId());
		}
		Account updatedAccount = accountRepo.save(updateAccount);
		return updatedAccount;
	}

	@Override
	public Object withdrawMoney(Account account) {
		String accountId = account.getAccountId();
		Customer customer = restTemplate.getForObject("http://CUSTOMER-MANAGEMENT-SERVICE/customer/"+accountId, Customer.class);
		
		Account existedAccount = this.accountRepo.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Account with given id is not found "+ accountId));
		
		if (customer.getAccountNumber().equals(account.getAccountNumber())) {
			if(existedAccount.getMoney()>account.getMoney()) {
				int updatedAmount = existedAccount.getMoney()-account.getMoney();
				existedAccount.setMoney(updatedAmount);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient Balance"); 
			}
				
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Number is mismatch with given id" + account.getAccountId());

		}
		Account updatedAccount = accountRepo.save(existedAccount);
		return updatedAccount;
	}

	@Override
	public Account getAccount(String accountId) {
		Account account = this.accountRepo.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Account with given id is not found "+ accountId));
		
		return account;
	}

	@Override
	public void deleteAccount(String accountId) {
		this.accountRepo.deleteById(accountId);
		
	}


}
