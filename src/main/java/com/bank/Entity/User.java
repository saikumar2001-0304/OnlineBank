package com.bank.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String password;
	private String email;
	//optional for notifications
	private String phoneNumber;
	//take enum also
	private String role;
	private String status;
	@CreationTimestamp
	@Column(name = "CREATED_TIME",updatable = false)
	private LocalDateTime createdTime;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public User(Long userId, String userName, String password, String email, String phoneNumber, String role,
			String status, LocalDateTime createdTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.status = status;
		this.createdTime = createdTime;
	}
	public User() {
		super();
	}
	
	
	
	/*
	 * Field Name Type Description id Long Primary Key username String Unique
	 * username password String Encrypted password (BCrypt) email String Unique
	 * email phone String Optional, for notifications role Enum/String Role:
	 * CUSTOMER, ADMIN createdAt Timestamp Account creation timestamp status String
	 * ACTIVE, DISABLED, etc.
	 */

	
	
}
