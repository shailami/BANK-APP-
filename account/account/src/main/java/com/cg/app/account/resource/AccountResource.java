package com.cg.app.account.resource;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.account.pojo.Account;
import com.cg.app.account.service.AccountService;

@RestController
@RequestMapping("/{accounts}")
public class AccountResource {

	@Autowired
	AccountService service;

	@GetMapping
	public ResponseEntity<List<Account>> getAll() {
		List<Account> account = service.getAll();
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@GetMapping("/{accountNumber}")
	public ResponseEntity<Account> getAccountById(@PathVariable int accountNumber) {
		/*
		 * ResponseEntity<Account> account = service.getAccountById(accountNumber);
		 * return new ResponseEntity<>(account, HttpStatus.OK);
		 */
		Optional<Account> account=service.getAccountById(accountNumber);
		if(account==null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		Account optionalAccount=account.get();
		return new ResponseEntity<>(optionalAccount, HttpStatus.OK);
	}

	@PutMapping("/{accountNumber}")
	public ResponseEntity<Account> updateBalance(@PathVariable int accountNumber, @RequestParam Double currentBalance) {
		Optional<Account> account = service.getAccountById(accountNumber);
		Account optionalAccount=account.get();
		optionalAccount.setCurrentBalance(currentBalance);
		service.addNew(optionalAccount);
		return new ResponseEntity<>(optionalAccount,HttpStatus.OK);
	}
	
	@GetMapping("/{accountNumber}/balance")
	public Double getBalance(@PathVariable int accountNumber) {
		Optional<Account> account = service.getAccountById(accountNumber);
		//Account optionalAccount=account.get();
		return account.get().getCurrentBalance();
	}
	@PostMapping
	public ResponseEntity<Account>addNew(@RequestBody Account account){
		service.addNew(account);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	  @DeleteMapping("/{accountNumber}")
	  public ResponseEntity<Account>delete(@PathVariable int accountNumber){
		  service.delete(accountNumber);
		return new ResponseEntity<>(HttpStatus.OK);
	  }
	  
	  
	  
	  
	 

}
