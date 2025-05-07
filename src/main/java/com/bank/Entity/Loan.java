package com.bank.Entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Loan {

	private Long id;
	private User user;
	private BigDecimal amount;
	private int tenure;
	private String staus;
	private Date createdAt;
	private Date approvedAt;

	public Loan() {
		super();
	}

	public Loan(Long id, User user, BigDecimal amount, int tenure, String staus, Date createdAt, Date approvedAt) {
		super();
		this.id = id;
		this.user = user;
		this.amount = amount;
		this.tenure = tenure;
		this.staus = staus;
		this.createdAt = createdAt;
		this.approvedAt = approvedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getStaus() {
		return staus;
	}

	public void setStaus(String staus) {
		this.staus = staus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(Date approvedAt) {
		this.approvedAt = approvedAt;
	}

}
