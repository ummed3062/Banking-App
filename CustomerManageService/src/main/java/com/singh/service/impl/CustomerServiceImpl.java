package com.singh.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.singh.entities.Account;
import com.singh.entities.Customer;
import com.singh.exceptions.ResourceNotFoundException;
import com.singh.repositories.CustomerRepository;
import com.singh.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	Account account = new Account();

	@Override
	public Customer addCustomer(Customer customer) {
		String randomCustomerId = UUID.randomUUID().toString();
		int randomNumber = new Random().nextInt(1000);
		String randomNum = String.valueOf(randomNumber);
		String randomAccountNumber  = randomNum+customer.getContactNumber();
		customer.setCustomerId(randomCustomerId);
		customer.setAccountNumber(randomAccountNumber);
		
	
//			Customer findByAccountNumber = this.customerRepo.findByAccountNumber(customer.getAccountNumber());
			
		this.account.setAccountId(randomCustomerId);
		this.account.setAccountHolderName(customer.getCustomerName());
		this.account.setAccountNumber(customer.getAccountNumber());
		this.account.setContactNumber(customer.getContactNumber());
		this.account.setMoney(0);
			
			
		Account postForObject = restTemplate.postForObject("http://ACCOUNT-MANAGEMENT-SERVICE/account", this.account, Account.class);
		System.out.println(postForObject.toString());
			
		
		Customer addedCustomer = this.customerRepo.save(customer);
		return addedCustomer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = this.customerRepo.findAll();
		return allCustomers;
	}

	@Override
	public Customer getSingleCustomer(String customerId) {
		Customer customer = this.customerRepo.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer with given id is not found " + customerId));
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		String customerId = customer.getCustomerId();
		Customer customerDetails = this.customerRepo.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer with given id is not found " + customerId));
		customerDetails.setCustomerName(customer.getCustomerName());
		customerDetails.setContactNumber(customer.getContactNumber());
		customerDetails.setCustomerAddress(customer.getCustomerAddress());
		customerDetails.setAadharNumber(customer.getAadharNumber());
		customerRepo.save(customerDetails);
		return customerDetails;
	}

	@Override
	public void deleteCustomer(String customerId) {
		restTemplate.delete("http://ACCOUNT-MANAGEMENT-SERVICE/account/"+customerId);
		this.customerRepo.deleteById(customerId);
	}

}
