 package com.bank.Dto;

import java.math.BigDecimal;

import com.bank.enums.AccountType;

public class AccountDto{
	 
	    private String accountNumber;
	    private AccountType accountType;
	    private BigDecimal balance;
		private String status;
	     
	    
	    public AccountDto() {}
	    
		
		public AccountDto(String accountNumber, AccountType accountType, BigDecimal balance, String status) {
			super();
			this.accountNumber = accountNumber;
			this.accountType = accountType;
			this.balance = balance;
			this.status = status;
		}


		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public AccountType getAccountType() {
			return accountType;
		}
		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}


		public BigDecimal getBalance() {
			return balance;
		}


		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}
	    
	    
	    
	}

