package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.repo.AccountRepository;
import com.dnb.jdbcdemo.repo.AccountRepositoryImpl;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	//@Qualifier("accountRepo2Impl")
	//AccountRepository accountRepository;
	AccountRepository accountRepo2Impl;
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepo2Impl.createAccount(account);
	}

	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		return accountRepo2Impl.getAccountById(accountId);
	}


	@Override
	public Optional<Account> deleteAccountById(String accountId) {
		// TODO Auto-generated method stub
		return accountRepo2Impl.deleteAccountById(accountId);
	}


	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepo2Impl.getAllAccounts();
	}

}
