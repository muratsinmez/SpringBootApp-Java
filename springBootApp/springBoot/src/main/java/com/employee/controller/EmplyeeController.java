package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmplyeeController {
	
	@Autowired
	private EmployeeService empservice;
	
	@PostMapping(path = "/addemployee")
	public void addEmployee(@RequestBody Employee emp) {
		
		empservice.addEmployee(emp);
		
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{name}")
	public void deleteEmployee(@PathVariable String name) {
		
		empservice.deleteEmployee(name);
	}
		
	@PutMapping(value = "/updateEmployee")
	public void updateEmployee(@RequestBody Employee  employee) {
		
		empservice.updateEmployee(employee);
		
	}
	
	@GetMapping(value = "/employees")
	public List<Employee> getEmployees(){
		
		
		return this.empservice.getEmployee();
	}
	
	
	@GetMapping(value = "/error")
	public String getPage() {
		return "Welcome";
	}
	
	
	
	
}	
