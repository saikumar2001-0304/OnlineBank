package com.bank.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.Dto.DtoMapper;
import com.bank.Dto.TranscationDto;
import com.bank.Dto.TranscationRequest;
import com.bank.Dto.TransferRequest;
import com.bank.Entity.Account;
import com.bank.Entity.Transaction;
import com.bank.Exception.AccountExce;
import com.bank.Repository.AccountRepository;
import com.bank.Repository.TranscationRepository;

@Service
@Transactional
public class TranscationServiceImpl implements TranscationService {

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	TranscationRepository transcationRepo;

	@Override
	public TranscationRequest depositMoney(TranscationRequest deposit) throws AccountExce {

		Account account = accountRepo.findByAccountNumber(deposit.getAccountNumber())
				.orElseThrow(() -> new AccountExce("Account not found"));

		account.setBalance(account.getBalance().add(deposit.getMoney()));
		accountRepo.save(account);

		Transaction transcation = new Transaction();
		transcation.setToAccount(account);
		transcation.setTimestamp(LocalDateTime.now());
		transcation.setType("Deposit");
		transcation.setAmount(deposit.getMoney());

		transcationRepo.save(transcation);

		return deposit;

	}

	@Override
	public TranscationRequest withdrawMoney(TranscationRequest withdraw) throws AccountExce {

		Account account = accountRepo.findByAccountNumber(withdraw.getAccountNumber())
				.orElseThrow(() -> new AccountExce("Account not found"));
		if (account.getBalance().compareTo(withdraw.getMoney()) < 0) {
			throw new AccountExce("Insufficient Balance");
		} else {
			account.setBalance(account.getBalance().subtract(withdraw.getMoney()));
			Transaction transcation = new Transaction();
			transcation.setToAccount(account);
			transcation.setTimestamp(LocalDateTime.now());
			transcation.setType("Withdraw");
			transcation.setAmount(withdraw.getMoney());

			transcationRepo.save(transcation);
		}

		return withdraw;

	}

	@Override
	public TransferRequest transfer(TransferRequest transfer) throws AccountExce {
		Account fromAccount = accountRepo.findByAccountNumber(transfer.getFromAccount())
				.orElseThrow(() -> new AccountExce("From Account not found"));
		Account toAccount = accountRepo.findByAccountNumber(transfer.getToAccount())
				.orElseThrow(() -> new AccountExce("To Account not found"));

		if (fromAccount.getBalance().compareTo(transfer.getAmount()) < 0) {
			throw new AccountExce("Insufficient Balance");
		} else {
			fromAccount.setBalance(fromAccount.getBalance().subtract(transfer.getAmount()));
			toAccount.setBalance(toAccount.getBalance().add(transfer.getAmount()));

			Transaction transcation = new Transaction();
			transcation.setToAccount(toAccount);
			transcation.setFromAccount(fromAccount);
			transcation.setTimestamp(LocalDateTime.now());
			transcation.setType("transfer");
			transcation.setAmount(transfer.getAmount());
			transcation.setDescription(transfer.getDescription());

			transcationRepo.save(transcation);

		}
		return transfer;

	}

	@Override
	public List<TranscationDto> transcationHistory(String accNo) throws AccountExce {

		accountRepo.findByAccountNumber(accNo).orElseThrow(() -> new AccountExce("Account not found"));

		List<Transaction> transcations = transcationRepo.findByFromAccountAccountNumberOrToAccountAccountNumber(accNo,
				accNo);

		return transcations.stream().map(transcation -> new DtoMapper().toTranscationDto(transcation))
				.collect(Collectors.toList());

	}

	@Override
	public BigDecimal balanceInquiry(String accNO) throws AccountExce {
		
		return accountRepo.findByAccountNumber(accNO).orElseThrow(() -> new AccountExce("Account not found")).getBalance();
		

	}

}
