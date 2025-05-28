package com.bank.Service;

import java.math.BigDecimal;
import java.util.List;

import com.bank.Dto.TranscationDto;
import com.bank.Dto.TranscationRequest;
import com.bank.Dto.TransferRequest;
import com.bank.Exception.AccountExce;

public interface TranscationService {

	public TranscationRequest depositMoney(TranscationRequest deposit) throws AccountExce;

	public TranscationRequest withdrawMoney(TranscationRequest deposit) throws AccountExce;

	public List<TranscationDto> transcationHistory(String accNo) throws AccountExce;


	TransferRequest transfer(TransferRequest transfer) throws AccountExce;

	BigDecimal balanceInquiry(String accNO) throws AccountExce;

	}
