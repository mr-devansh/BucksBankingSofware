package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value="SELECT * from employee where city=:city",nativeQuery = true)
	public List<Employee> fetchAllEmployee(String city);
	
	@Query("Select e from Employee e where e.salary >= e.salary")
			public List<Employee> fetchAllEmployeeWithSalary(Double salary);
		
	@Query(name = "Employee.countEmp")
	int countEmp();
	
	List<Employee> findAllByDepartmentDeptName(String deptName);
}
