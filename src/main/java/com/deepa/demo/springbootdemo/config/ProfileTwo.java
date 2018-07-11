package com.deepa.demo.springbootdemo.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProfileTwo {

	@PostConstruct
	public void see() {
		System.out.println("prod");
	}
	
	@Bean
	@ConfigurationProperties("app.datasource.two")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
