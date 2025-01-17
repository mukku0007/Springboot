package com.banking.controller;

import java.util.List;
import java.util.Map;

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

import com.banking.model.Account;
import com.banking.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/banking")
public class AccountController {

	private final AccountService accountService;
	
	@PostMapping("/addAccount")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		
		return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAccountById/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
		Account accountById = accountService.getAccountById(id);
		return ResponseEntity.ok(accountById);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<Account> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		
		Double depositeAmount = request.get("Deposite Amount");
		Account account = accountService.deposit(id, depositeAmount);
		return ResponseEntity.ok(account);
	}
	
	@PutMapping("{id}/withdraw")
	public ResponseEntity<Account> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		
		Double withdrAwamount = request.get("Withdraw Amount");
		Account account = accountService.withdraw(id, withdrAwamount);
		return ResponseEntity.ok(account);
		
	}
	
	@GetMapping("getAllAccounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		
		List<Account> allAccount = accountService.getAllAccount();
		return ResponseEntity.status(HttpStatus.FOUND).body(allAccount);
	}
	
	@DeleteMapping("/deleteAccountById/{id}")
	public ResponseEntity<String> deleteAccountById(@PathVariable Long id) {
		accountService.deleteAccountById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Account deleted sucessfully for Id: "+id);
	}
}
