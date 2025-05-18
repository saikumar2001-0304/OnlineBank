package com.bank.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Entity.Account;
import com.bank.Exception.AccountExce;
import com.bank.Repository.AccountRepository;
import com.bank.enums.AccountType;


public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository acRepo;
	
	@Override
	public Account saveAccount(Account account, AccountType type) throws AccountExce {
		
		if(acRepo.existsByAccountNumber(account.getAccountNumber())) {
			throw new AccountExce("account number already existed");
		}else {
			account.setAcType(type);
			Account save = acRepo.save(account);
			return save;
		}
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> all = acRepo.findAll();
		return all;
	}

	@Override
	public Account getByAccountId(long accountId) throws AccountExce {
		Account account = acRepo.findById(accountId).get();
		if(account.getAccountId().equals(accountId)) {
			return account;
		}else {
			throw new AccountExce("account id was not found");
		}
	}

	@Override
	public String deleteAccount(long accountId)throws AccountExce {
		Account account = acRepo.findById(accountId).get();
		if(account.getAccountId().equals(accountId)) {
			return "Account deleted successfully";
		}else {
			throw new AccountExce("account id was not found");
		}
	}

	@Override
	public Account updateAccount() throws AccountExce {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addbalance(String accountNo,BigDecimal amount) throws AccountExce {
		Account account = acRepo.findByAccountNumber(accountNo);
		String bal;
		if(account.getAccountNumber().equals(accountNo)) {
			BigDecimal balance = account.getBalance();
			BigDecimal currentBal = balance.add(amount);
			account.setBalance(currentBal);
			 bal="previous balance was: ->"+balance+"current balance: ->"+currentBal+" thank you";
			return bal;
		}else {
			 throw new AccountExce("account number was not found");
		}
	}

	@Override
	public String withdrawBalance(String accountNo, BigDecimal amount) throws AccountExce {
		Account account = acRepo.findByAccountNumber(accountNo);
		String bal;
		if(account.getAccountNumber().equals(accountNo)) {
			BigDecimal balance = account.getBalance();
			BigDecimal currentBal = balance.subtract(amount);
			account.setBalance(currentBal);
			 bal="previous balance was: ->"+balance+"current balance: ->"+currentBal+" thank you";
			return bal;
		}else {
			 throw new AccountExce("account number was not found");
		}
	}

	
}
