package com.dnb.jdbcdemo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

public class DBUtils {
	
	//static is used to create only one instance
	private static Properties properties;
	
	private static Properties getProperties() {
		//reading the file
		InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
		//checking if input stream is not empty - only then object is created
		if(inputStream!=null) {
			//object creation
			properties = new Properties();
			try {
				//loading the input stream into the properties reference variable
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return properties;
		}
		System.out.println(inputStream==null);
		return properties;
	}
	
	public static Optional<Connection> getConnection() {
		Properties properties = getProperties();
		
		
		try {
			Connection connection = DriverManager.getConnection(properties.getProperty("jdbc.url"), 
					properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
			return Optional.of(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(DBUtils.getProperties());
	}
	
}
