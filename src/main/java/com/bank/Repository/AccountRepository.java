package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.Account;
import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	public boolean existsByAccountNumber(String accountNumber);
	Account findByAccountNumber(String accountNumber);
}
