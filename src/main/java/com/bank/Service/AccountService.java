package com.bank.Service;

import java.math.BigDecimal;
import java.util.List;

import com.bank.Dto.AccountDto;
import com.bank.Entity.Account;
import com.bank.Exception.AccountExce;
import com.bank.enums.AccountType;

public interface AccountService {
	
	AccountDto create(AccountDto accountDto,String userId,AccountType type) throws AccountExce;

	List<Account> getAllAccounts();
	
	String updateAccount(String accNo,AccountType type)throws AccountExce;
	String deleteAccount(String accNo)throws AccountExce;

	AccountDto getByAccountId(String accNo) throws AccountExce;
	
}
