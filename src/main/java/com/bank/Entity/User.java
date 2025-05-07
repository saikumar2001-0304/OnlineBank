package com.bank.Entity;

import jakarta.persistence.Entity;

@Entity
public class User {

	private Long userId;
	private String userName;
	private String password;
	private String email;
	//optional for notifications
	private String phoneNumber;
	//take enum also
	private String role;
	private String status;
	//createdAt	Timestamp	Account creation timestamp
	
	
}
