package com.employeeaudit.process;

import java.util.ArrayList;

import com.employeeaudit.dto.Employee;
import com.employeeaudit.dto.EmployeeAuditDetails;
import com.employeeaudit.dto.EmployeeHistory;

public class EmployeeAuditDetailsProcess {
	public ArrayList<EmployeeAuditDetails> getEmployeeAuditDetails(ArrayList<Employee> employeeDetails, ArrayList<EmployeeHistory> employeeHistoryDetails) {
		ArrayList<EmployeeAuditDetails> empAuditDetails = new ArrayList<EmployeeAuditDetails>();
		Employee tempEmp = null;
		ArrayList<EmployeeHistory> tempHistory = new ArrayList<EmployeeHistory>();
		
		for (Employee employeeDetail : employeeDetails) {
			tempEmp = employeeDetail;
			for (EmployeeHistory employeeHistory : employeeHistoryDetails) {
				if(tempEmp.getEmpId() == employeeHistory.getEmpId()) {
					tempHistory.add(employeeHistory);
				}
			}
			empAuditDetails.add(new EmployeeAuditDetails(tempEmp, tempHistory));
			tempEmp = null;
			tempHistory = null;
		}
		
		return empAuditDetails;
	}
	
	public ArrayList<EmployeeAuditDetails> sortEmployeeAuditDetailsByName(String order) {
		ArrayList<EmployeeAuditDetails> sortedDetails = new ArrayList<EmployeeAuditDetails>();
		
		/*
		 * need to write logic
		 */
		
		return sortedDetails;
	}
}
