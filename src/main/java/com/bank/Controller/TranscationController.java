package com.bank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<TranscationRequest> deposit(@RequestBody TranscationRequest deposit) throws AccountExce{
		
	
			return new ResponseEntity<>(service.depositMoney(deposit),HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("withdraw")
	public ResponseEntity<TranscationRequest> Withdraw(@RequestBody TranscationRequest withdraw) throws AccountExce {
		
		return new ResponseEntity<>(service.withdrawMoney(withdraw),HttpStatus.OK);
		
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<TransferRequest> transfer(@RequestBody TransferRequest transfer) throws AccountExce {
		return new ResponseEntity<>(service.transfer(transfer),HttpStatus.OK);
		
	}
	
	
}