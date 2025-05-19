package com.bank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Entity.DepositRequest;
import com.bank.Exception.AccountExce;
import com.bank.Service.TranscationServiceImpl;

@RestController
@RequestMapping("/transcation")
public class TranscationController {
	
	
	@Autowired
	TranscationServiceImpl service ;
	
	
	@PostMapping("/deposit")
	public void deposit(@RequestBody DepositRequest deposit){
		
		try {
			service.depositMoney(deposit.getAccountNumber(),deposit.getMoney());
		} catch (AccountExce e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}