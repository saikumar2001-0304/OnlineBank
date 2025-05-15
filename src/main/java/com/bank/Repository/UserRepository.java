package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public boolean existsByemail(String email);
	public User findByEmail(String email);
}
