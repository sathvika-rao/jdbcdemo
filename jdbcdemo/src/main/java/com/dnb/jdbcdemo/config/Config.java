package com.dnb.jdbcdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.test.DBConfig;

@Configuration
@ComponentScan(basePackages = "com.test,com.dnb.jdbcdemo")
//@ComponentScans(value = { @ComponentScan ("com.dnb.jdbcdemo"), @ComponentScan("com.test") })
@PropertySource("application.properties")
//@Import(DBConfig.class)

public class Config {
	@Autowired
	private Environment environment;
}
