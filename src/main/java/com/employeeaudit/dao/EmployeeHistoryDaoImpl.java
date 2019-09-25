package com.employeeaudit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.employeeaudit.connection.DBConnection;
import com.employeeaudit.dto.EmployeeHistory;

/**
 * @author 45228
 * This Class is to get the history of employee from the Database
 *
 */
public class EmployeeHistoryDaoImpl {
Connection con;
	
	/*
	 * To get all employee history details from DB table.
	 */
	public ArrayList<EmployeeHistory> getEmployeeHistory() {
		con = DBConnection.connect();
		Statement stmt;
		ArrayList<EmployeeHistory> empHistoryDetails = new ArrayList<EmployeeHistory>() ;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employeehistory");  
			while(rs.next()) {
				java.sql.Date salaryCreditedDate = rs.getDate(2);
//				System.out.println(salaryCreditedDate+" "+new java.util.Date(salaryCreditedDate.getTime()));
				empHistoryDetails.add(new EmployeeHistory(rs.getString(1), new java.util.Date(salaryCreditedDate.getTime()), rs.getInt(3)));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in getEmployeeHistory()");
		}    
		return empHistoryDetails;
	}
}
