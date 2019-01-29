package com.cg.app.transaction.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.app.transaction.dataset.CurrentDataSet;
import com.cg.app.transaction.entity.Transaction;
import com.cg.app.transaction.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionResource {
	@Autowired
	private TransactionService service;
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping
	public ResponseEntity<Transaction> withdraw(@RequestBody Transaction transaction) {
		System.out.println("hello trans");
		ResponseEntity<Double> entity = restTemplate
				.getForEntity("http://account/accounts/" + transaction.getAccountNumber() + "/balance", Double.class);
		Double currentBalance = entity.getBody();
		System.out.println(currentBalance);
		Double updateBalance = service.withdraw(transaction.getAccountNumber(), transaction.getAmount(),
				currentBalance);
		restTemplate.put(
				"http://account/accounts/" + transaction.getAccountNumber() + "?currentBalance=" + updateBalance, null);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/deposit")
	public ResponseEntity<Transaction> Deposit(@RequestBody Transaction transaction) {
		System.out.println("hello trans");
		ResponseEntity<Double> entity = restTemplate
				.getForEntity("http://account/accounts/" + transaction.getAccountNumber() + "/balance", Double.class);
		Double currentBalance = entity.getBody();
		System.out.println(currentBalance);
		Double updateBalance = service.deposit(transaction.getAccountNumber(), transaction.getAmount(), currentBalance);
		restTemplate.put(
				"http://account/accounts/" + transaction.getAccountNumber() + "?currentBalance=" + updateBalance, null);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/fundtransfer")
	public ResponseEntity<Transaction> FundTransfer(@RequestParam String senderAccountNumber,

			@RequestParam String receiverAccountNumber, Double amount) {
		Integer senderAccountNumber1 = Integer.parseInt(senderAccountNumber);
		Integer receiverAccountNumber1 = Integer.parseInt(receiverAccountNumber);

		ResponseEntity<Double> entity = restTemplate
				.getForEntity("http://account/accounts/" + senderAccountNumber1 + "/balance", Double.class);
		Double currentBalance = entity.getBody();
		Double updateBalance = service.withdraw(senderAccountNumber1, amount, currentBalance);
		restTemplate.put("http://account/accounts/" + senderAccountNumber1 + "?currentBalance=" + updateBalance, null);

		ResponseEntity<Double> entity2 = restTemplate
				.getForEntity("http://account/accounts/" + receiverAccountNumber1 + "/balance", Double.class);
		Double currentBalance2 = entity2.getBody();
		System.out.println(currentBalance);
		Double updateBalance2 = service.deposit(receiverAccountNumber1, amount, currentBalance2);
		restTemplate.put("http://account/accounts/" + receiverAccountNumber1 + "?currentBalance=" + updateBalance2,
				null);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public List<Transaction> getAllTransactions() {
		return service.getAllTransactions();
		/*
		 * ResponseEntity<Double> entity = restTemplate
		 * .getForEntity("http://account/accounts/115/balance", Double.class);
		 * System.out.println(entity.getBody()); return "hello";
		 */

	}

	@GetMapping
	public ResponseEntity<CurrentDataSet> listOfTransactions() {
		CurrentDataSet currentDataSet = new CurrentDataSet();
		List<Transaction> transactions = service.getAllTransactions();
		currentDataSet.setTransaction(transactions);
		return new ResponseEntity<>(currentDataSet, HttpStatus.OK);
	}

	@GetMapping("/demo")
	public String demo() {
		return "working demo";
	}

}
