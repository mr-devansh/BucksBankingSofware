package com.way2learnonline;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

	@Configuration
	@ComponentScan
	public class ApplicationConfig {
		
		@Autowired
		private DataSource dataSource;
		
		@Bean
		public DataSource dataSource(){		
			BasicDataSource dataSource= new BasicDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUsername("postgres");
			dataSource.setPassword("root");
			dataSource.setUrl("jdbc:postgresql://localhost:5432/banking");
			return dataSource;			
		}
	}
