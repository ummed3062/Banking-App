package com.singh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singh.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
