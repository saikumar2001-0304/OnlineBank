package com.bank.Controller;

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
import com.bank.Service.AccountServiceImpl;
import com.bank.enums.AccountType;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl accService;

	@PostMapping("/create/{userId}")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto, @PathVariable String userId,
			AccountType type)throws AccountExce {

		return new ResponseEntity<>(accService.create(accountDto, userId,type ), HttpStatus.CREATED);
	}

	
	@GetMapping("/get/{id}")
	public ResponseEntity<AccountDto> getbyId(@PathVariable(name="id") String AccountNo) throws AccountExce{
		return new ResponseEntity<>(accService.getByAccountId(AccountNo),HttpStatus.OK);
	}
	@GetMapping("/list")
	public ResponseEntity<List<Account>>getList(){
		List<Account> allAccounts = accService.getAllAccounts();
		return new ResponseEntity<>(allAccounts,HttpStatus.OK);
	}
	// here we can use patch mapping also because we are updaing only particular payload 
	@PutMapping("/update/{id}")
	public ResponseEntity<String>updateAccount(@PathVariable(name="id") String AccountNo,AccountType type) throws AccountExce{
		String updateAccount = accService.updateAccount(AccountNo, type);
		return new ResponseEntity<>(updateAccount,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable(name="id") String AccountNo) throws AccountExce{
		String deleteAccount = accService.deleteAccount(AccountNo);
		return new ResponseEntity<>(deleteAccount,HttpStatus.OK);
	}
}
