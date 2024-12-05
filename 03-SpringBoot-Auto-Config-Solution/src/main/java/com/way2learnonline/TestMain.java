package com.way2learnonline;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.way2learnonline.service.BankService;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class TestMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context =  SpringApplication.run(TestMain.class); 
		BankService bankService= context.getBean(BankService.class);
		bankService.transfer(1L, 2L, 2);
	}

}
