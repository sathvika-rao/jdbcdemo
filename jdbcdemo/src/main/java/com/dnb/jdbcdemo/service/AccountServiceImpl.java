package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.repo.AccountRepository;
import com.dnb.jdbcdemo.repo.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService {
	
	private static AccountService accountService;
	AccountRepository accountRepository = AccountRepositoryImpl.getInstance();

	public static AccountService getInstance() {
		synchronized (AccountServiceImpl.class) {
			if (accountService == null) {
				accountService = new AccountServiceImpl();
			}	
			return accountService;
		}
	}
	
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.createAccount(account);
	}

	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		return accountRepository.getAccountById(accountId);
	}


	@Override
	public Optional<Account> deleteAccountById(String accountId) {
		// TODO Auto-generated method stub
		return accountRepository.deleteAccountById(accountId);
	}


	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.getAllAccounts();
	}

}
