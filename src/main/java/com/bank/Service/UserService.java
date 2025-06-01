package com.bank.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.bank.Configuration.CustomUserDetails;
import com.bank.Dto.UserDto;
import com.bank.Entity.User;
import com.bank.Exception.UserException;
import com.bank.enums.UserRole;


public interface UserService {
	
	UserDto createUser(UserDto request,UserRole role) throws UserException;

	User userbyId(String userId)throws UserException ;
	List<User> getLsit();
	String deleteuser(String userId)throws UserException;
	User updateUser(User user, String email) throws UserException;

	public  CustomUserDetails UserServiceImpl(String email) throws UserException;
}
