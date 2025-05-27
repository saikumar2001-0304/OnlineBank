package com.bank.Service;

import com.bank.Dto.TranscationRequest;
import com.bank.Dto.TransferRequest;
import com.bank.Exception.AccountExce;

public interface TranscationService {

	public TranscationRequest depositMoney(TranscationRequest deposit) throws AccountExce;

	public TranscationRequest withdrawMoney(TranscationRequest deposit) throws AccountExce;

	public void transcationHistory();

	public void balanceInquiry();

	TransferRequest transfer(TransferRequest transfer) throws AccountExce;
}
