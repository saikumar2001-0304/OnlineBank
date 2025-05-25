package com.bank.Service;

import java.util.List;

import com.bank.Dto.UserDto;
import com.bank.Entity.User;
import com.bank.Exception.UserException;
import com.bank.enums.UserRole;


public interface UserService {
	
	UserDto createUser(UserDto request,UserRole role);

	User addUser(User user)throws UserException;
	User userbyId(String userId)throws UserException ;
	List<User> getLsit();
	String deleteuser(String userId)throws UserException;
	User updateUser(User user, String email) throws UserException;
}
