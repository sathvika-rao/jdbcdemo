package com.dnb.jdbcdemo.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.utils.DBUtils;

//it should have only one instance - so work with singleton design pattern
public class AccountRepositoryImpl implements AccountRepository {

	private AccountRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	// reference of the interface can be taken, just its instance cannot be created
	private static AccountRepository accountRepository;

	public static AccountRepository getInstance() {
		synchronized (AccountRepositoryImpl.class) {
			if (accountRepository == null) {
				accountRepository = new AccountRepositoryImpl();
			}
			return accountRepository;
		}
	}

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
		String createAccountStatement = "insert into account "
				+ "(accountId, accountHolderName, accountType, balance, contactNumber, address, accountCreatedDate, dob, accountStatus)"
				+ "values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatment = null;

		if (connection.isPresent()) {
			try {
				preparedStatment = connection.get().prepareStatement(createAccountStatement);
				preparedStatment.setString(1, account.getAccountId());
				preparedStatment.setString(2, account.getAccountHolderName());
				preparedStatment.setString(3, account.getAccountType());
				preparedStatment.setFloat(4, account.getBalance());
				preparedStatment.setString(5, account.getContactNumber());
				preparedStatment.setString(6, account.getAddress());
				preparedStatment.setDate(7, Date.valueOf(account.getAccountCreatedDate()));
				preparedStatment.setDate(8, Date.valueOf(account.getDob()));
				preparedStatment.setBoolean(9, account.isAccountStatus());

				int result = preparedStatment.executeUpdate();

				if (result > 0) {
					// return new Account();
					return account; // it should return the actual account object from DB
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (connection.isPresent()) {
					DBUtils.closeConnection(connection.get());
				}
			}
		}
		return null;
	}

	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String query = "select * from account where accountId=?";
		
		if(connection.isPresent()) {
				try {
					preparedStatement = connection.get().prepareStatement(query);
					preparedStatement.setString(1, accountId);
					resultSet = preparedStatement.executeQuery();
					if(resultSet.next()) {
						Account account = new Account();
						account.setAccountId(resultSet.getString("accountId"));
						account.setAccountHolderName(resultSet.getString("accountHolderName"));
						account.setAccountType(resultSet.getString("accountType"));
						account.setBalance(resultSet.getFloat("balance"));
						account.setContactNumber(resultSet.getString("contactNumber"));
						account.setAddress(resultSet.getString("address"));
						account.setAccountCreatedDate(resultSet.getDate("accountCreatedDate").toLocalDate());
						account.setDob(resultSet.getDate("dob").toLocalDate());
						account.setAccountStatus(resultSet.getBoolean("accountStatus"));
						return Optional.ofNullable(account);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					if(connection.isPresent()) {
						DBUtils.closeConnection(connection.get());
					}
				}
				
		}
		
		return null;
	}

	@Override
	public Optional<Account> deleteAccountById(String accountId) {
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "delete from account where accountId=?";
		
		if(connection.isPresent()) {
				try {
					preparedStatement = connection.get().prepareStatement(query);
					preparedStatement.setString(1, accountId);
					preparedStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					if(connection.isPresent()) {
						DBUtils.closeConnection(connection.get());
					}
				}
				
		}
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Account> accounts = new ArrayList<Account>();
		
		String query = "select * from account where accountId=?";
		
		if(connection.isPresent()) {
				try {
					preparedStatement = connection.get().prepareStatement(query);
					resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						Account account = new Account();
						account.setAccountId(resultSet.getString("accountId"));
						account.setAccountHolderName(resultSet.getString("accountHolderName"));
						account.setAccountType(resultSet.getString("accountType"));
						account.setBalance(resultSet.getFloat("balance"));
						account.setContactNumber(resultSet.getString("contactNumber"));
						account.setAddress(resultSet.getString("address"));
						account.setAccountCreatedDate(resultSet.getDate("accountCreatedDate").toLocalDate());
						account.setDob(resultSet.getDate("dob").toLocalDate());
						account.setAccountStatus(resultSet.getBoolean("accountStatus"));
						accounts.add(account);
					}
					return accounts;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					if(connection.isPresent()) {
						DBUtils.closeConnection(connection.get());
					}
				}
				
		}
		
		return null;
	}

}
