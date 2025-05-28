package com.bank.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Dto.AccountDto;
import com.bank.Dto.DtoMapper;
import com.bank.Entity.Account;
import com.bank.Entity.Transaction;
import com.bank.Entity.User;
import com.bank.Exception.AccountExce;
import com.bank.Exception.UserException;
import com.bank.Repository.AccountRepository;
import com.bank.Repository.TranscationRepository;
import com.bank.Repository.UserRepository;
import com.bank.enums.AccountType;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository acRepo;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TranscationRepository trRepo;
	
	@Autowired
	private DtoMapper mapper;

	public AccountDto create(AccountDto accountDto, String userId, AccountType type) {
		
		User user = userRepo.findByUserId(userId).orElseThrow(() -> new RuntimeException("User not found"));

		Account account = mapper.toAccount(accountDto,type);
		account.setUser(user);
		
		acRepo.save(account);
		
		if(account.getBalance().compareTo(BigDecimal.valueOf(0))>0) {
		Transaction transcation = new Transaction();
		transcation.setToAccount(account);
		transcation.setTimestamp(LocalDateTime.now());
		transcation.setType("Deposit");
		transcation.setAmount(account.getBalance());
		trRepo.save(transcation);
		}
		return mapper.toAccountDto(account);

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
	public AccountDto getByAccountId(String accNo) throws AccountExce {
	
		DtoMapper mapper = new DtoMapper();
		return mapper.toAccountDto(acRepo.findByAccountNumber(accNo).orElseThrow(()-> new AccountExce("Account not found")))     ;
	}
//
//	@Override
//	public String deleteAccount(long accountId) throws AccountExce {
//		Account account = acRepo.findById(accountId).get();
//		if (account.getAccountId().equals(accountId)) {
//			return "Account deleted successfully";
//		} else {
//			throw new AccountExce("account id was not found");
//		}
//	}
//
//	@Override
//	public Account updateAccount() throws AccountExce {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
