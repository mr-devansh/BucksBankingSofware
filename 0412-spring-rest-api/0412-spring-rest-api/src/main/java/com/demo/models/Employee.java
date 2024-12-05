	package com.demo.models;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	@NotNull(message="Employee Name should'nt be blank")
	@Size(min = 6, max = 255, message="Name should be between 6 and 255 characters")
	private String empName;
	@NotNull
	@Size(min = 3, max = 255)
	private String city;
	@NotNull
    @Min(value = 1000, message = "Salary should be greater than or equal to 1000")
	private double empSalary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	} 
	@Override
	public String toString() {
		return "\nEmployee [empId=" + empId + ", empName=" + empName + ", city=" + city + ", empSalary=" + empSalary
				+ "]";
	}
}
