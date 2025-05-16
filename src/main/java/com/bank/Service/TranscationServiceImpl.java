package com.bank.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.bank.Entity.Account;
import com.bank.Repository.AccountRepository;

public class TranscationServiceImpl implements TranscationService{
	

	@Autowired
	Account account ;
	@Autowired
	AccountRepository accountrepo;
	
	

	@Override
	public void depositMoney(BigDecimal money) {
	
		account.setBalance(account.getBalance().add(money));
	
		
	}

	@Override
	public void withdrawMoney() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transcationHistory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void balanceInquiry() {
		// TODO Auto-generated method stub
		
	}

}
