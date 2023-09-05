package com.dnb.jdbcdemo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.repo.AccountRepositoryImpl;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.service.AccountServiceImpl;

public class JDBCApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/*Optional class
		String a = null;
		String x = null;
		
		Optional<String> optional = Optional.ofNullable(a);
		System.out.println(optional.isPresent());
		System.out.println(optional.isEmpty());*/
		
		java.sql.Date date = Date.valueOf(LocalDate.now());
		System.out.println(date);
		
		Account account = new Account();
		account.setAccountId("41249");
		account.setAccountHolderName("Sathvika");
		account.setAccountType("Savings");
		account.setBalance(53479);
		account.setContactNumber("6362702247");
		account.setAddress("Alwal");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date1 = "09/08/2001";
		
		//LocalDate ld = LocalDate.of(2001, 12, 9);
		LocalDate ld = LocalDate.parse(date1,formatter);
		account.setDob(ld);
		account.setAccountStatus(true);
		
		AccountService accountService = AccountServiceImpl.getInstance();
		
		System.out.println("Testing git push");
		while(true) {
			System.out.println("Enter your choice");
			String str = sc.nextLine();
			switch(str) {
			case "createAccount" : accountService.createAccount(account);
			break;
			
			case "getAccountById" : {
				Optional<Account> acc = accountService.getAccountById("41249");
				System.out.println(acc.isPresent());
				break;
			}
			
			case "deleteAccountById" : {
				accountService.deleteAccountById("41249");
				break;
			}
			
			case "getAllAccounts" : accountService.getAllAccounts();
			break;
			
			case "exit" : System.exit(0);
			}
		
		}
		
		
	}
	//System.exit
}
