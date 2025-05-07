package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
