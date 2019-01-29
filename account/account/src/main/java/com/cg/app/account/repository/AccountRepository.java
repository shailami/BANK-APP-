package com.cg.app.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.account.pojo.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account,Integer> {

}
