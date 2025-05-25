package com.bank.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Dto.AccountDto;
import com.bank.Dto.DtoMapper;
import com.bank.Entity.Account;
import com.bank.Entity.User;
import com.bank.Exception.AccountExce;
import com.bank.Exception.UserException;
import com.bank.Repository.AccountRepository;
import com.bank.Repository.UserRepository;
import com.bank.enums.AccountType;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository acRepo;

	@Autowired
	private UserRepository userRepo;

	public AccountDto create(AccountDto accountDto, String userId) {
		
		User user = userRepo.findByUserId(userId).orElseThrow(() -> new RuntimeException("User not found"));

		Account account = DtoMapper.toAccount(accountDto);
		account.setUser(user);
		
		acRepo.save(account);
	
		return DtoMapper.toAccountDto(account);

	}

	@Override
	public Account saveAccount(Account account, AccountType type) throws AccountExce {

		if (acRepo.existsByAccountNumber(account.getAccountNumber())) {
			throw new AccountExce("account number already existed");
		} else {
			account.setAcType(type);
			Account save = acRepo.save(account);
			return save;
		}
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> all = acRepo.findAll();
		return all;
	}

	@Override
	public Account getByAccountId(long accountId) throws AccountExce {
		Account account = acRepo.findById(accountId).get();
		if (account.getAccountId().equals(accountId)) {
			return account;
		} else {
			throw new AccountExce("account id was not found");
		}
	}

	@Override
	public String deleteAccount(long accountId) throws AccountExce {
		Account account = acRepo.findById(accountId).get();
		if (account.getAccountId().equals(accountId)) {
			return "Account deleted successfully";
		} else {
			throw new AccountExce("account id was not found");
		}
	}

	@Override
	public Account updateAccount() throws AccountExce {
		// TODO Auto-generated method stub
		return null;
	}

}
