package com.employee.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.DBUtil.DBUtil;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	Connection connection;
	
	public EmployeeServiceImpl() throws SQLException {
		
		connection = DBUtil.getConnection();
		
	}
	
	
	@Override
	public void addEmployee(Employee emp) {
		String employeeName = emp.getEmployeeName();
		String employeeAddress = emp.getEmplyeeAddress();
		
		String insertQuery = "INSERT INTO staff_id VALUES('"+ employeeName +"', '" +employeeAddress+ "' ;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("done");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	public void deleteEmployee(String name) {
		
		String deleteQuery = "DELETE FROM staff_id WHERE employee = '" +name+ "' ;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}


	@Override
	public void updateEmployee(Employee employee) {
		String   employeeName = employee.getEmployeeName();
		String employeeAddress = employee.getEmplyeeAddress();
		
		String updateQuery = "UPDATE staff_id SET employeeName = '"+employeeName+"', employeeAddress = '"+employeeAddress+"' ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	@Autowired
	static List<Employee> employeeList = new ArrayList();
	
	@Override
	public List<Employee> getEmployee() {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM staff_id");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeName(rs.getString(1));
				emp.setEmplyeeAddress(rs.getString(2));
				employeeList.add(emp);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return employeeList;
		
		
	}
	

}
