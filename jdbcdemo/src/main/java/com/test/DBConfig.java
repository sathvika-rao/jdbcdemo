package com.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnb.jdbcdemo.utils.DataSourceBean;

@Configuration
public class DBConfig {
	
	@Bean //to get only one object - gets created once and can be used multiple times
	public DataSourceBean dataSourceBean() {
		return new DataSourceBean();
	}
	
	@Bean()
	public List<String> arrayDemo() {
		return Arrays.asList("a", "b", "c", "d", "e");
	}
}
