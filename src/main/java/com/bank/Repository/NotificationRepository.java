package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
