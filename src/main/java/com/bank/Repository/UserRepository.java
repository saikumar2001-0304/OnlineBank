package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
	
	public boolean existsByemail(String email);
	public User findByEmail(String email);
	
	Optional<User> findByUserId(Long userId);
}
