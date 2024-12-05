package com.way2learnonline;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.way2learnonline.service.BankService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class,InfrastructureConfig.class);		
		 
		BankService bankService = context.getBean(BankService.class);
		
		try {
			bankService.transfer(new Long(1), new Long(2), 5000);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
