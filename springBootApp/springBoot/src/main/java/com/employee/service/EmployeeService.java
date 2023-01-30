package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee.model.Employee;


@Repository
public interface EmployeeService {
	
	
	public List<Employee> getEmployee();

	
	public void addEmployee(Employee emp);
	
	
	public void deleteEmployee(String name);
	
	
	public void updateEmployee(Employee employee);

	
	
}
