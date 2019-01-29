package com.cg.app.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.app.account.pojo.Account;

public interface AccountService {

	List<Account> getAll();

	void addNew(Account account);

	Optional<Account> getAccountById(int accountNumber);

	void delete(int accountNumber);

}