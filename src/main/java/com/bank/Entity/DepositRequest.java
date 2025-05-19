package com.bank.Entity;

import java.math.BigDecimal;

public class DepositRequest {
	
	String accountNumber;
	BigDecimal money;
	
	
	public DepositRequest() {
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
