package com.bank.Dto;

import com.bank.Entity.Account;
import com.bank.Entity.User;

public class DtoMapper {
	
	
	public static User toUser(UserDto request) {
		User user = new User();
		user.setUserName(request.getUserName());
		user.setPassword(request.getPassword());
		user.setEmail(request.getEmail());
		user.setPhoneNumber(request.getPhoneNumber());
		
		return user;
		
	}
	
	public static UserDto toUserRequest(User user) {
		UserDto userRequest = new UserDto();
		userRequest.setUserId(user.getUserId());
		userRequest.setUserName(user.getUserName());
		userRequest.setPassword(user.getPassword());
		userRequest.setEmail(user.getEmail());
		userRequest.setPhoneNumber(user.getPhoneNumber());
		
		return userRequest;
		
	}
	
	
	public static Account toAccount(AccountDto request) {
		Account account = new Account();
		account.setAccountNumber(request.getAccountNumber());
		account.setAcType(request.getAccountType());
		account.setBalance(request.getBalance());
		account.setStatus(request.getStatus());
		return account;
		
	}
	
	public static AccountDto toAccountDto(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setAccountType(account.getAcType() );
		accountDto.setBalance(account.getBalance());
		accountDto.setStatus(account.getStatus());
		return accountDto;
		
	}

}
