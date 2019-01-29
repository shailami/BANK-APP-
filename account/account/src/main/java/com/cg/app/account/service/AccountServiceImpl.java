package com.cg.app.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.account.pojo.Account;
import com.cg.app.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository repository;

	/* (non-Javadoc)
	 * @see com.cg.app.account.service.AccountService#getAll()
	 */
	@Override
	public List<Account> getAll() {
		return repository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.cg.app.account.service.AccountService#addNew(com.cg.app.account.pojo.Account)
	 */
	@Override
	public void addNew(Account account) {
		repository.save(account);
	}

	@Override
	public Optional<Account> getAccountById(int accountNumber) {
		Optional<Account> account=repository.findById(accountNumber);
		return account ;
	}

	@Override
	public void delete(int accountNumber) {
		Optional<Account> optionalAccount=repository.findById(accountNumber);
		Account account = optionalAccount.get();
		repository.delete(account);
	}

}
