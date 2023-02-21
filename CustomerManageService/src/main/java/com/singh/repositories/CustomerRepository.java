package com.singh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singh.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

	Customer findByAccountNumber(String accountNumber);

	

}
