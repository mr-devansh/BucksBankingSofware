package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.model.Employee;
import com.demo.repositories.EmployeeRepository;
import com.demo.services.EmployeeService;

@SpringBootApplication
public class Application {

	@Autowired	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		//Employee emp = new Employee("deepanshu jaiswal", "delhi", 23000.00);
		Employee emp2 = new Employee("yash sharma", "noida", 26500.00);

		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
//		System.out.println(employeeService.findEmployeeById(1));
//		
//		System.out.println(employeeService.saveEmployee(emp2));
//		
//		Employee emp3 = new Employee(2, "deepanshu jaiswal", "new delhi", 23500.00);
//		System.out.println(employeeService.updateEmployee(emp3));

		//System.out.println(employeeService.deleteEmployee(52) );
		
		System.out.println(employeeService.findAllEmployee());
	}

}
