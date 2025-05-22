package com.bank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Dto.TranscationRequest;
import com.bank.Dto.TransferRequest;
import com.bank.Exception.AccountExce;
import com.bank.Service.TranscationServiceImpl;

@RestController
@RequestMapping("/transcation")
public class TranscationController {
	
	
	@Autowired
	TranscationServiceImpl service ;
	
	
	@PostMapping("/deposit")
	public void deposit(@RequestBody TranscationRequest deposit) throws AccountExce{
		
	
			service.depositMoney(deposit.getAccountNumber(),deposit.getMoney());
		
		
	}
	
	
	@PostMapping("withdraw")
	public void Withdraw(@RequestBody TranscationRequest withdraw) throws AccountExce {
		
		service.withdrawMoney(withdraw.getAccountNumber(),withdraw.getMoney());
		
	}
	
	@PostMapping("/transfer")
	public void transfer(@RequestBody TransferRequest transfer) throws AccountExce {
		service.transfer(transfer.getFromAccount(),transfer.getToAccount(),transfer.getAmount(),transfer.getDescription());
		
	}
	
	
}