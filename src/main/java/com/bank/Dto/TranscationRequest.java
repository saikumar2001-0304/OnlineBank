package com.bank.Dto;

import java.math.BigDecimal;

public class TranscationRequest {
	
	String accountNumber;
	BigDecimal money;
	
	
	public TranscationRequest() {
		super();
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	

}
