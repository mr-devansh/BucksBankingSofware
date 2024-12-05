package com.demo.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depId;
	private String deptName;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "department")
	Set<Employee> employees;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}
	public Department(int depId, String deptName) {
		super();
		this.depId = depId;
		this.deptName = deptName;
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "\nDepartment [depId=" + depId + ", deptName=" + deptName + "]";
	}
}
