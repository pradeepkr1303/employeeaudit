package com.employeeaudit.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

//This class is to establish the MySql DB Connection
public class DBConnection {
	/*
	 * connect() is to establish the connect return con
	 */
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Exception in Class.forName()");
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeaudit", "root", "Activate123");
		} catch (SQLSyntaxErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Database not available or syntax error in query");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in Connection");
		}
		return con;
	}
}
