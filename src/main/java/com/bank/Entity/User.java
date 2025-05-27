package com.bank.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.bank.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "userDetails")
public class User {

	@Id
	private String userId;
	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
	private String userName;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", message = "Password must be at least 8 characters long and include uppercase, lowercase, and a number")
	private String password;
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Column(unique = true)
	private String email;
	// optional for notifications
	@Pattern(regexp = "^\\+\\d{1,3}\\d{8,14}$", message = "Phone number must include country code and be valid, e.g. +919876543210")
	private String phoneNumber;
	@NotNull(message = "User type is required")
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@Pattern(regexp = "ACTIVE|INACTIVE|BLOCKED", message = "Status must be one of: ACTIVE, INACTIVE, or BLOCKED")
	private String status;
	@CreationTimestamp
	@Column(name = "CREATED_TIME", updatable = false)
	private LocalDateTime createdTime;

	@Size(min = 10, max = 10, message = "pan number length must be 10 characters")
	@Column(unique = true, length = 10, nullable = false)
	private String pan;

	@OneToMany(mappedBy = "user")
	private List<Account> account;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
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

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public User(String userId,
			@NotBlank(message = "Username is required") @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters") String userName,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", message = "Password must be at least 8 characters long and include uppercase, lowercase, and a number") String password,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
			@Pattern(regexp = "^\\+\\d{1,3}\\d{8,14}$", message = "Phone number must include country code and be valid, e.g. +919876543210") String phoneNumber,
			@NotNull(message = "User type is required") UserRole role,
			@Pattern(regexp = "ACTIVE|INACTIVE|BLOCKED", message = "Status must be one of: ACTIVE, INACTIVE, or BLOCKED") String status,
			LocalDateTime createdTime, String pan, List<Account> account) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.status = status;
		this.createdTime = createdTime;
		this.pan = pan;
		this.account = account;
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
