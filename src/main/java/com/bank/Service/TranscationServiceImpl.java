package com.bank.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Entity.Account;
import com.bank.Entity.Transaction;
import com.bank.Exception.AccountExce;
import com.bank.Repository.AccountRepository;
import com.bank.Repository.TranscationRepository;

@Service
public class TranscationServiceImpl implements TranscationService {

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	TranscationRepository transcationRepo;

	@Override
	public void depositMoney(String accNum, BigDecimal money) throws AccountExce {

		Account account = accountRepo.findByAccountNumber(accNum)
				.orElseThrow(() -> new AccountExce("Account not found"));

		account.setBalance(account.getBalance().add(money));
		accountRepo.save(account);

		Transaction transcation = new Transaction();
		transcation.setToAccount(account);
		transcation.setTimestamp(LocalDateTime.now());
		transcation.setType("Deposit");
		transcation.setAmount(money);
		

		transcationRepo.save(transcation);

	}

	@Override
	public void withdrawMoney(String accNum, BigDecimal money) throws AccountExce {
		
		Account account = accountRepo.findByAccountNumber(accNum)
							.orElseThrow(() -> new AccountExce("Account not found"));
		if(account.getBalance().compareTo(money)<0) {
			throw new AccountExce("Insufficient Balance");
		}else {
			account.setBalance(account.getBalance().subtract(money));
			Transaction transcation = new Transaction();
			transcation.setToAccount(account);
			transcation.setTimestamp(LocalDateTime.now());
			transcation.setType("Withdraw");
			transcation.setAmount(money);
			
			transcationRepo.save(transcation);
		}
	
		

	}

	@Override
	public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount,String description) throws AccountExce {
		Account fromAccount = accountRepo.findByAccountNumber(fromAccountNumber)
							.orElseThrow(()-> new AccountExce("From Account not found"));
		Account toAccount = accountRepo.findByAccountNumber(toAccountNumber)
				.orElseThrow(()-> new AccountExce("To Account not found"));
		
		if(fromAccount.getBalance().compareTo(amount)<0) {
			throw new AccountExce("Insufficient Balance");
		}
		else {
			fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
			toAccount.setBalance(toAccount.getBalance().add(amount));
			
			Transaction transcation = new Transaction();
			transcation.setToAccount(toAccount);
			transcation.setFromAccount(fromAccount);
			transcation.setTimestamp(LocalDateTime.now());
			transcation.setType("transfer");
			transcation.setAmount(amount);
			transcation.setDescription(description);
			
			transcationRepo.save(transcation);
			
		}

	}

	@Override
	public void transcationHistory() {
		// TODO Auto-generated method stub

	}

	@Override
	public void balanceInquiry() {
		// TODO Auto-generated method stub

	}

}
