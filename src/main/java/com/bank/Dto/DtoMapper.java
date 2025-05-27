package com.bank.Dto;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.bank.CustomGenerator.IdGeneratorService;
import com.bank.Entity.Account;
import com.bank.Entity.User;
import com.bank.enums.AccountType;
import com.bank.enums.UserRole;

@Component
public class DtoMapper {
	

	@Autowired
	private IdGeneratorService idservice;

	public  User toUser(UserDto userdto, UserRole role) {
		User user = new User();
		user.setUserId(idservice.generateUserId());
		user.setUserName(userdto.getUserName());
		user.setPassword(userdto.getPassword());
		user.setEmail(userdto.getEmail());
		user.setPhoneNumber(userdto.getPhoneNumber());
		user.setRole(role);
		user.setStatus(userdto.getStatus());
		user.setPan(userdto.getPan());
		return user;
		
	}
	
	public  UserDto toUserDto(User user) {
		UserDto userdto = new UserDto();
		userdto.setUserId(user.getUserId());
		userdto.setUserName(user.getUserName());
		userdto.setPassword(user.getPassword());
		userdto.setEmail(user.getEmail());
		userdto.setPhoneNumber(user.getPhoneNumber());
		userdto.setRole(user.getRole());
		userdto.setStatus(user.getStatus());
		userdto.setPan(user.getPan());
		
		return userdto;
		
	}
	
	
	public  Account toAccount(AccountDto accountdto, AccountType type) {
		Account account = new Account();
		account.setAccountNumber(idservice.generateAccountNumber());
		account.setAcType(type);
		account.setBalance(accountdto.getBalance());
		account.setStatus(accountdto.getStatus());
		return account;
		
	}
	
	public  AccountDto toAccountDto(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setAccountType(account.getAcType() );
		accountDto.setBalance(account.getBalance());
		accountDto.setStatus(account.getStatus());
		return accountDto;
		
	}

}
