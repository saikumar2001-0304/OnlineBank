package com.bank.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_Id")
	private User user;
	private BigDecimal amount;
	private int tenure;
	private String staus;
	@CreationTimestamp
	@Column(name = "CREATED_TIME",updatable = false)
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(name = "APPROVED_TIME",insertable = false)
	private LocalDateTime approvedAt;

	public Loan() {
		super();
	}

	public Loan(Long id, User user, BigDecimal amount, int tenure, String staus, LocalDateTime createdAt, LocalDateTime approvedAt) {
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(LocalDateTime approvedAt) {
		this.approvedAt = approvedAt;
	}

}
