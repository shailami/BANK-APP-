package com.cg.app.transaction.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.app.transaction.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	public List<Transaction> findByTransactionDateBetween(LocalDate startDate,LocalDate endDate);
}
