package com.bank.Service;

import java.math.BigDecimal;
import java.util.List;

import com.bank.Dto.AccountDto;
import com.bank.Entity.Account;
import com.bank.Exception.AccountExce;
import com.bank.enums.AccountType;

public interface AccountService {
	
	AccountDto create(AccountDto accountDto,Long userId);

	Account saveAccount(Account account,AccountType type)throws AccountExce;
	List<Account> getAllAccounts();
	Account getByAccountId(long accountId)throws AccountExce;
	Account updateAccount()throws AccountExce;
	String addbalance(String accountNo,BigDecimal amount) throws AccountExce;
	String withdrawBalance(String accountNo,BigDecimal amount) throws AccountExce;
	String deleteAccount(long accountId)throws AccountExce;
	
}
