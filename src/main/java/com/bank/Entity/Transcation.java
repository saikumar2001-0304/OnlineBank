package com.bank.Entity;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Transcation {

	private Long Id;
	private Account fromAccount;
	private Account toAccount;
	private String type;
	private Date timestamp;
	private String description;

	public Transcation() {
		super();
	}

	public Transcation(Long id, Account fromAccount, Account toAccount, String type, Date timestamp,
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

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
