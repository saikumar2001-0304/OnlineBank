package com.bank.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Dto.TranscationDto;
import com.bank.Dto.TranscationRequest;
import com.bank.Dto.TransferRequest;
import com.bank.Exception.AccountExce;
import com.bank.Service.TranscationServiceImpl;

@RestController
@RequestMapping("/transcation")
public class TranscationController {

	@Autowired
	TranscationServiceImpl service;

	@PostMapping("/deposit")
	public ResponseEntity<TranscationRequest> deposit(@RequestBody TranscationRequest deposit) throws AccountExce {

		return new ResponseEntity<>(service.depositMoney(deposit), HttpStatus.OK);

	}

	@PostMapping("/withdraw")
	public ResponseEntity<TranscationRequest> Withdraw(@RequestBody TranscationRequest withdraw) throws AccountExce {

		return new ResponseEntity<>(service.withdrawMoney(withdraw), HttpStatus.OK);

	}

	@PostMapping("/transfer")
	public ResponseEntity<TransferRequest> transfer(@RequestBody TransferRequest transfer) throws AccountExce {
		return new ResponseEntity<>(service.transfer(transfer), HttpStatus.OK);

	}

	@GetMapping("/transcation-history/{accNo}")
	public ResponseEntity< List<TranscationDto> >transcationHistory(@PathVariable String accNo) throws AccountExce{
		
		
		return new ResponseEntity<>(service.transcationHistory(accNo),HttpStatus.OK);
		
	}

	@GetMapping("/balance-enquiry/{accNo}")
	public ResponseEntity<BigDecimal> balanceEnquiry(@PathVariable String accNo) throws AccountExce{
		
		return new ResponseEntity<>(service.balanceInquiry(accNo),HttpStatus.OK);
	}

	
}