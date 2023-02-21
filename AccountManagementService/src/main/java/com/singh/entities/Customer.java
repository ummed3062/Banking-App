package com.singh.entities;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

	private String customerId;
	private String accountNumber;
	private String customerName;
	private String customerAddress;
	private String contactNumber;
	private String aadharNumber;
}
