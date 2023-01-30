package com.employee.model;

public class Employee {

	String employeeName;
	String emplyeeAddress;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmplyeeAddress() {
		return emplyeeAddress;
	}
	public void setEmplyeeAddress(String emplyeeAddress) {
		this.emplyeeAddress = emplyeeAddress;
	}
	public Employee(String employeeName, String emplyeeAddress) {
		super();
		this.employeeName = employeeName;
		this.emplyeeAddress = emplyeeAddress;
	}
	public Employee() {
		super();
		
	}
	@Override
	public String toString() {
		return "employee [employeeName=" + employeeName + ", emplyeeAddress=" + emplyeeAddress + "]";
	}
	
	
	
}
