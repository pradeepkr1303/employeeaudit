package com.employeeaudit.dto;

import java.util.ArrayList;

/*
 * DTO for Employee and History details
 */
public class EmployeeAuditDetails {
	Employee employee;
	ArrayList<EmployeeHistory> employeeHistory;
	
	public EmployeeAuditDetails(Employee employee, ArrayList<EmployeeHistory> employeeHistory) {
		super();
		this.employee = employee;
		this.employeeHistory = employeeHistory;
	}
	
	public EmployeeAuditDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public ArrayList<EmployeeHistory> getEmployeeHistory() {
		return employeeHistory;
	}
	
	public void setEmployeeHistory(ArrayList<EmployeeHistory> employeeHistory) {
		this.employeeHistory = employeeHistory;
	}

	@Override
	public String toString() {
		return "EmployeeAuditDetails [employee=" + employee + ", employeeHistory=" + employeeHistory + "]";
	}
	
}
