package com.demo.controllers;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exceptions.EmployeeNotFoundException;
import com.demo.models.Employee;
import com.demo.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/api/employees")
	public ResponseEntity<List<Employee>> findAllEmployee() {
		List<Employee> listy = employeeService.findAllEmployees();
		return new ResponseEntity<List<Employee>>(listy, HttpStatus.OK);
	}
	@GetMapping("/api/employees/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable("id") int empId) {
		Employee emp = employeeService.findEmployeeById(empId);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	@PostMapping("/api/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee emp = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	@PutMapping("/api/employees/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@Valid @RequestBody Employee employee) {
		Employee emp = employeeService.updateEmployee(id, employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	@DeleteMapping("/api/employees/delete/{id}")
	public Boolean deleteEmployee(@PathVariable("id") int empId) {
		return employeeService.deleteEmployee(empId);
	}
	
}
