package com.bank.Entity;

import java.time.LocalDateTime;
import java.util.Date;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Account fromAccount;			
	@ManyToOne(fetch = FetchType.LAZY)
	private Account toAccount;
	private String type;
	private LocalDateTime timestamp;
	private String description;

	public Transaction() {
		super();
	}

	public Transaction(Long id, Account fromAccount, Account toAccount, String type, LocalDateTime timestamp,
			String description) {
		super();
		Id = id;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.type = type;
		this.timestamp = timestamp;
		this.description = description;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
