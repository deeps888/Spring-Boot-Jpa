package com.deepa.demo.springbootdemo.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev", "default"})
public class ProfileOne {

	@PostConstruct
	public void see() {
		System.out.println("dev");
	}
	
	@Bean
	@ConfigurationProperties("app.datasource.one")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
