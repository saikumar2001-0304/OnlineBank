package com.bank.Service;

import java.math.BigDecimal;

import com.bank.Exception.AccountExce;

public interface TranscationService {
	
	public void depositMoney(String accNum , BigDecimal money) throws AccountExce;
	public void withdrawMoney(String accNum, BigDecimal money) throws AccountExce;

	public void transcationHistory();
	public void balanceInquiry();
	void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount, String description) throws AccountExce;


}
