package com.bank.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TranscationDto {
	
	private Long id;
    private String fromAccountNumber;
    private String toAccountNumber;
    private String type;
    private LocalDateTime timestamp;
    private String description;
    private BigDecimal amount;
    
    
    public TranscationDto() {}
    
    
	public TranscationDto(Long id, String fromAccountNumber, String toAccountNumber, String type,
			LocalDateTime timestamp, String description, BigDecimal amount) {
		super();
		this.id = id;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.type = type;
		this.timestamp = timestamp;
		this.description = description;
		this.amount = amount;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFromAccountNumber() {
		return fromAccountNumber;
	}


	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}


	public String getToAccountNumber() {
		return toAccountNumber;
	}


	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
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


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
    
    

}
