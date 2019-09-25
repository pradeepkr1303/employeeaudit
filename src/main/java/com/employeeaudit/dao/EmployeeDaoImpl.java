package com.employeeaudit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.employeeaudit.connection.DBConnection;
import com.employeeaudit.dto.Employee;


/**
 * This Class is to get the details of employee from the Database
 *
 */
public class EmployeeDaoImpl {
	Connection con;
	
	/*
	 * To get all employee details from DB table.
	 */
	public ArrayList<Employee> getEmployees() {
		con = DBConnection.connect();
		Statement stmt;
		ArrayList<Employee> empDetails = new ArrayList<Employee>() ;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee");  
			while(rs.next()) {
				java.sql.Date doj = rs.getDate(3);
				empDetails.add(new Employee(rs.getString(1), rs.getString(2), new java.util.Date(doj.getTime()), rs.getInt(4)));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in getEmployees()");
		}    
		return empDetails;
	}
}
