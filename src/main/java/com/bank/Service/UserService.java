package com.bank.Service;

import java.util.List;

import com.bank.Entity.User;
import com.bank.Exception.UserException;


public interface UserService {

	User addUser(User user)throws UserException;
	User userbyId(Long userId)throws UserException ;
	List<User> getLsit();
	String deleteuser(Long userId)throws UserException;
	User updateUser(User user, String email) throws UserException;
}
