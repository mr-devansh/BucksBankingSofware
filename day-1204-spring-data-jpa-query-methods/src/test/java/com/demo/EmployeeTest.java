package com.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.Employee;
import com.demo.repositories.EmployeeRepository;

@SpringBootTest
public class EmployeeTest {
	@Autowired
	private EmployeeRepository empRepo;
	@Test
	public void testFetchEmployeeByCity() {
		List<Employee> listy =  empRepo.fetchAllEmployee("Chicago");
		System.out.println(listy);
	}
}
