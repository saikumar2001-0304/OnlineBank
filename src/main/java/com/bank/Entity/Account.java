package com.bank.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.bank.enums.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_user_id", "ac_type"})
    }
)
 public class Account {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long accountId;
	@Id
	private String accountNumber;
	@ManyToOne
	private User user;
	
	@NotNull(message = "Balance is required")
	@DecimalMin(value = "0.00", inclusive = true, message = "Balance must be non-negative")
	private BigDecimal balance;
	@NotNull(message = "Account type is required")
	@Enumerated(EnumType.STRING)
	private AccountType acType;
	@NotBlank(message = "Status is required")
	@Pattern(regexp = "ACTIVE|INACTIVE|BLOCKED", message = "Status must be ACTIVE, INACTIVE, or BLOCKED")
	private String status;
	@CreationTimestamp
	@Column(name = "CREATED_TIME", updatable = false)
	private LocalDateTime createdTime;
	
	@OneToMany(mappedBy ="fromAccount")
	private List<Transaction> sent;
	@OneToMany(mappedBy="toAccount")
	private List<Transaction> received;

	

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

	
	public List<Transaction> getSent() {
		return sent;
	}

	public void setSent(List<Transaction> sent) {
		this.sent = sent;
	}

	public List<Transaction> getReceived() {
		return received;
	}

	public void setReceived(List<Transaction> received) {
		this.received = received;
	}

	public Account() {
		super();
	}

	public Account( User user, String accountNumber, BigDecimal balance, AccountType acType,
			String status, LocalDateTime createdTime, List<Transaction> sent, List<Transaction> received) {
		super();
		
		this.user = user;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.acType = acType;
		this.status = status;
		this.createdTime = createdTime;
		this.sent = sent;
		this.received = received;
	}

	

	/*
	 * ield Name Type Description id Long Primary Key user User Many-to-One relation
	 * to User accountNumber String Unique account number balance BigDecimal Current
	 * balance type Enum/String SAVINGS, CURRENT, etc. status String ACTIVE,
	 * BLOCKED, CLOSED createdAt Timestamp Account creation timestamp
	 */

}
