package com.demo.services;
import com.demo.exceptions.EmployeeNotFoundException;
import com.demo.models.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	public Employee findEmployeeById(int id) {
		return employeeRepository.findById(id)
				.orElseThrow(()-> new EmployeeNotFoundException("Employee with ID "+id+", not Found"));
		
	}
	public Employee updateEmployee(int id, Employee employee) {
		Employee emp = findEmployeeById(id);
		if(emp!=null) {
			emp = employee;
			emp.setEmpId(id);
			return employeeRepository.save(emp);
		}
		return null;
	}
	public boolean deleteEmployee(int id) {
		if(findEmployeeById(id)!=null) {
			employeeRepository.deleteById(id);;
			return true;
		}
		return false;
	}
	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
}
