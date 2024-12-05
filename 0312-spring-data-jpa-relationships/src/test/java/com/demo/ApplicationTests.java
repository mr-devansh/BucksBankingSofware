package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.Department;
import com.demo.model.Employee;
import com.demo.repositories.DepartmentRepository;
import com.demo.repositories.EmployeeRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private DepartmentRepository depRep;
	@Autowired
	private EmployeeRepository empRep;
	@Test
	void contextLoads() {
	}
//		@Test
//		public void testCreateDepartment() {
//			Department dep = new Department("HR");
//			depRep.save(dep);
//		}
//		@Test
//		public void testCreateEmployee() {
//			Employee emp = new Employee("deepanshu", "pune", 16000);
//			empRep.save(emp);
//		}
	@Test
	public void testAction() {
		Optional<Employee> OptEmp = empRep.findById(4);
		Optional<Department> Optdep = depRep.findById(2);
		if(Optdep.isPresent()) {
			Department dep = Optdep.get();
			Employee emp = OptEmp.get();
			emp.setDepartment(dep);
			empRep.save(emp);
		}
	}
//	@Test
//	@Transactional
//	public void testFindEmployee() {
//		Optional<Employee> emp = empRep.findById(2);
//		System.out.println(emp);
//	}
}
	












