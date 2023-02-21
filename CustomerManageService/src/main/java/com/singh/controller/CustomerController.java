package com.singh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singh.entities.Customer;
import com.singh.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer addedCustomer = this.customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedCustomer);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> allCustomers = this.customerService.getAllCustomers();
		return ResponseEntity.ok(allCustomers);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getSingleCustomer(@PathVariable String customerId){
		Customer customer = this.customerService.getSingleCustomer(customerId);
		return ResponseEntity.ok(customer);
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable String customerId){
		this.customerService.deleteCustomer(customerId);
	}
	
	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer updatedCustomer = this.customerService.updateCustomer(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	

}
