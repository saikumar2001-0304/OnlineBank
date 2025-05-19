package com.bank.Service;

import java.math.BigDecimal;

import com.bank.Exception.AccountExce;

public interface TranscationService {
	
	public void depositMoney(String accNum , BigDecimal money) throws AccountExce;
	public void withdrawMoney();
	public void transfer();
	public void transcationHistory();
	public void balanceInquiry();


}
