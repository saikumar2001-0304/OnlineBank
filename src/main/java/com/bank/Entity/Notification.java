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
	public Long getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNotificationContent() {
		return NotificationContent;
	}
	public void setNotificationContent(String notificationContent) {
		NotificationContent = notificationContent;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public Notification(Long notificationId, User user, String notificationContent, String type,
			LocalDateTime createdTime) {
		super();
		this.notificationId = notificationId;
		this.user = user;
		NotificationContent = notificationContent;
		this.type = type;
		this.createdTime = createdTime;
	}
	public Notification() {
		super();
	}
	
	
	
	/*
	 * Field Name Type Description id Long Primary Key user User User who receives
	 * the notification message String Notification content type String EMAIL, SMS
	 * createdAt Timestamp Notification time
	 */
}
