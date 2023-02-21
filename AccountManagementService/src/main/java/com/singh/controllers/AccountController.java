package com.singh.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singh.entities.Account;
import com.singh.entities.Customer;
import com.singh.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Account> accountCreate(@RequestBody Account account){
		Account createdAccount = this.accountService.createAccount(account);
		return ResponseEntity.ok(createdAccount);
	}
	
	@PutMapping("/addmoney")
	public ResponseEntity<Object> addMoney(@RequestBody Account account){
		Object addMoney = this.accountService.addMoney(account);
		return ResponseEntity.ok(addMoney);
	}
	
	@PutMapping("/withdrawmoney")
	public ResponseEntity<Object> withdrawMoney(@RequestBody Account account){
		Object moneyWithdrawn = this.accountService.withdrawMoney(account);
		return ResponseEntity.ok(moneyWithdrawn);
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getAccount(@PathVariable String accountId){
		Account account = this.accountService.getAccount(accountId);
		return ResponseEntity.ok(account);
	}
	
	
	@DeleteMapping("/{accountId}")
	public String accountDelete(@PathVariable String accountId){
		this.accountService.deleteAccount(accountId);
		return "Account Deleted successfully";
	}
	
	
}
