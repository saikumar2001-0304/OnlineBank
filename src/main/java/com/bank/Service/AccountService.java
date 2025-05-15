package com.bank.Service;

import java.util.List;

import com.bank.Entity.Account;
import com.bank.enums.AccountType;

public interface AccountService {

	Account saveAccount(Account account,String userName,String status,AccountType type);
	List<Account> getAllAccounts();
	Account getByAccountId(long accountId);
	String deleteAccount(long accountId);
	
}
