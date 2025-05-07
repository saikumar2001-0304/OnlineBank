package com.bank.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notificationId;
	private User user;
	private String NotificationContent;
	private String type;
	@CreationTimestamp
	@Column(name = "CREATED_TIME",updatable = false)
	private LocalDateTime createdTime;
	
	/*
	 * Field Name Type Description id Long Primary Key user User User who receives
	 * the notification message String Notification content type String EMAIL, SMS
	 * createdAt Timestamp Notification time
	 */
}
