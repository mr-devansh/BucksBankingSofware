package com.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Employee;
import com.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	public Employee findEmployeeById(int id) {
		Optional<Employee> optionEmployee = employeeRepository.findById(id);
		if(optionEmployee.isPresent()) {
			return optionEmployee.get();
		}
		return null;
	}
	public Employee updateEmployee(Employee employee) {
		if(findEmployeeById(employee.getEmpId())!=null) {
			return employeeRepository.save(employee);
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
	public List<Employee> findAllEmployee(){
		List<Employee> ans = new ArrayList<>();
		employeeRepository.findAll().forEach(ans::add);
		return ans;
	}
	public EmployeeService() {
		super();
		// TODO Auto-generated constructor stub
	}
	private EmployeeRepository employeeRepository;
}
