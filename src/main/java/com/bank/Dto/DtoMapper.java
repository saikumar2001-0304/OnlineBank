package com.bank.Dto;

import com.bank.Entity.Account;
import com.bank.Entity.User;
import com.bank.enums.UserRole;

public class DtoMapper {
	
	
	public static User toUser(UserDto userdto, UserRole role) {
		User user = new User();
		user.setUserName(userdto.getUserName());
		user.setPassword(userdto.getPassword());
		user.setEmail(userdto.getEmail());
		user.setPhoneNumber(userdto.getPhoneNumber());
		user.setRole(role);
		user.setStatus(userdto.getStatus());
		return user;
		
	}
	
	public static UserDto toUserDto(User user) {
		UserDto userdto = new UserDto();
		userdto.setUserId(user.getUserId());
		userdto.setUserName(user.getUserName());
		userdto.setPassword(user.getPassword());
		userdto.setEmail(user.getEmail());
		userdto.setPhoneNumber(user.getPhoneNumber());
		userdto.setRole(user.getRole());
		userdto.setStatus(user.getStatus());
		
		return userdto;
		
	}
	
	
	public static Account toAccount(AccountDto accountdto) {
		Account account = new Account();
		account.setAccountNumber(accountdto.getAccountNumber());
		account.setAcType(accountdto.getAccountType());
		account.setBalance(accountdto.getBalance());
		account.setStatus(accountdto.getStatus());
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
