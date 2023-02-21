package com.singh.service;

import java.util.List;

import com.singh.entities.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	
	List<Customer> getAllCustomers();
	
	Customer getSingleCustomer(String customerId);
	
	Customer updateCustomer(Customer customer);
	
	void deleteCustomer(String customerId);
	
	

}
