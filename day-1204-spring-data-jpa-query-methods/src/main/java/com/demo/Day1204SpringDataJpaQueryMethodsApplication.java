package com.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.model.Employee;
import com.demo.repositories.EmployeeRepository;

@SpringBootApplication
public class Day1204SpringDataJpaQueryMethodsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(Day1204SpringDataJpaQueryMethodsApplication.class, args);
		EmployeeRepository empRepo = context.getBean(EmployeeRepository.class);
		List<Employee> listy = empRepo.fetchAllEmployee("Chicago");
		System.out.println(listy);
		System.out.println("---------------------------------");
		List<Employee> listy2 = empRepo.fetchAllEmployeeWithSalary(72000.00);
		System.out.println(listy2);
		System.out.println("---------------------------------");	
		List<Employee> listy3 = empRepo.findAllByDepartmentDeptName("HR");
		listy.forEach(System.out::println);
	}

}
