package com.cg.app.transaction.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.transaction.entity.Transaction;
import com.cg.app.transaction.entity.TransactionType;
import com.cg.app.transaction.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository; 
	
	public double withdraw(int accountNumber,double amount,double currentBalance) {
		if(amount<=currentBalance) {
			Transaction transaction=new Transaction();
			transaction.setAccountNumber(accountNumber);
			transaction.setAmount(amount);
			currentBalance-=amount;
			transaction.setCurrentBalance(currentBalance);
			transaction.setTransactionDate(LocalDateTime.now());
			transaction.setTransactionDetails("WITHDRWAL SUCCESSFULL");
			transaction.setTransactionType(TransactionType.WITHDRAW);
			repository.save(transaction);
		}
		return currentBalance;
	}

	public Object findById(int accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double deposit(Integer accountNumber, Double amount, Double currentBalance) {
		if(amount>0) {
			Transaction transaction=new Transaction();
			transaction.setAccountNumber(accountNumber);
			transaction.setAmount(amount);
			currentBalance+=amount;
			transaction.setCurrentBalance(currentBalance);
			transaction.setTransactionDate(LocalDateTime.now());
			transaction.setTransactionDetails("DEPOSITED SUCCESSFULLY");
			transaction.setTransactionType(TransactionType.DEPOSIT);
			repository.save(transaction);
		}
		return currentBalance;
	}

	public List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate) {
		return repository.findByTransactionDateBetween(startDate, endDate);
	}

	public List<Transaction> getAllTransactions() {
		return repository.findAll();
	}
	
}
