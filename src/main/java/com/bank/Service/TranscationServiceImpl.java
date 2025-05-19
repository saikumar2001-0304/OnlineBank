package com.bank.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Entity.Account;
import com.bank.Entity.DepositRequest;
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
		

		transcationRepo.save(transcation);

	}

	@Override
	public void withdrawMoney() {
		// TODO Auto-generated method stub

	}

	@Override
	public void transfer() {
		// TODO Auto-generated method stub

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
