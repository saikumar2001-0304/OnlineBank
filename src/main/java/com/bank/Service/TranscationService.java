package com.bank.Service;

import java.math.BigDecimal;

public interface TranscationService {
	
	public void depositMoney(BigDecimal money);
	public void withdrawMoney();
	public void transfer();
	public void transcationHistory();
	public void balanceInquiry();


}
