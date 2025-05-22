package com.bank.Dto;

import java.math.BigDecimal;

public class TransferRequest {

	private String fromAccountNumber;
	private String toAccountNumber;
	private BigDecimal amount;
	private String description;
	
	public TransferRequest() {};
	


	public TransferRequest(String fromAccount, String toAccount, BigDecimal amount, String description) {
		super();
		this.fromAccountNumber = fromAccount;
		this.toAccountNumber = toAccount;
		this.amount = amount;
		this.description = description;
	}



	public String getFromAccount() {
		return fromAccountNumber;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccountNumber = fromAccount;
	}

	public String getToAccount() {
		return toAccountNumber;
	}

	public void setToAccount(String toAccount) {
		this.toAccountNumber = toAccount;
	}

	
	
	public BigDecimal getAmount() {
		return amount;
	}



	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
