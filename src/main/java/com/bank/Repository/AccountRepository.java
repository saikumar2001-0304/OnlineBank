package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.Account;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account, Serializable> {

	public boolean existsByAccountNumber(String accountNumber);
	Optional<Account> findByAccountNumber(String accountNumber);
	void deleteByAccountNumber(String accountNumber);
	
     
}
