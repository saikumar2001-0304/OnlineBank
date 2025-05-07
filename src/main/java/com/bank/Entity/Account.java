package com.bank.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.bank.enums.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private User user;
//	@Pattern(regexp = "regexp = \"^[1-9]\\\\d{8,17}$\", message = \"Account number must be 9 to 18 digits and not start with 0\"")
	private String accountNumber;
	private BigDecimal balance;
	private AccountType acType;
	private String status;
	@CreationTimestamp
	@Column(name = "CREATED_TIME",updatable = false)
	private LocalDateTime createdTime;
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public AccountType getAcType() {
		return acType;
	}
	public void setAcType(AccountType acType) {
		this.acType = acType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public Account(Long accountId, User user, String accountNumber, BigDecimal balance, AccountType acType,
			String status, LocalDateTime createdTime) {
		super();
		this.accountId = accountId;
		this.user = user;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.acType = acType;
		this.status = status;
		this.createdTime = createdTime;
	}
	public Account() {
		super();
	}	
	
	
	/*ield Name	Type	Description
	id	Long	Primary Key
	user	User	Many-to-One relation to User
	accountNumber	String	Unique account number
	balance	BigDecimal	Current balance
	type	Enum/String	SAVINGS, CURRENT, etc.
	status	String	ACTIVE, BLOCKED, CLOSED
	createdAt	Timestamp	Account creation timestamp*/

	
}
