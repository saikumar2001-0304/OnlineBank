package com.bank.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Dto.AccountDto;
import com.bank.Entity.Account;
import com.bank.Exception.AccountExce;
import com.bank.Exception.UserException;
import com.bank.Service.AccountServiceImpl;
import com.bank.enums.AccountType;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl accService;
	
	@PostMapping("/create/{userId}")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto,@PathVariable String userId ) {
		
		return new ResponseEntity<>(accService.create(accountDto,userId),HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/save")
	public ResponseEntity<Account> addAccount(@RequestBody Account account,AccountType type) throws AccountExce{
		Account account2 = accService.saveAccount(account, type);
		return new ResponseEntity<>(account2,HttpStatus.CREATED);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Account> getbyId(@PathVariable(name="id") Long AccountId) throws AccountExce{
		Account byAccountId = accService.getByAccountId(AccountId);
		return new ResponseEntity<>(byAccountId,HttpStatus.OK);
	}
	@GetMapping("/list")
	public ResponseEntity<List<Account>>getList(){
		List<Account> allAccounts = accService.getAllAccounts();
		return new ResponseEntity<>(allAccounts,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Account>updateAccount() throws AccountExce{
		Account updateAccount = accService.updateAccount();
		return new ResponseEntity<>(updateAccount,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable(name="id") Long AccountId) throws AccountExce{
		String deleteAccount = accService.deleteAccount(AccountId);
		return new ResponseEntity<>(deleteAccount,HttpStatus.OK);
	}
}
