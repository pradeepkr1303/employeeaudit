package com.employeeaudit.client;

import java.util.ArrayList;

import com.employeeaudit.dao.EmployeeDaoImpl;
import com.employeeaudit.dao.EmployeeHistoryDaoImpl;
import com.employeeaudit.dto.Employee;
import com.employeeaudit.dto.EmployeeAuditDetails;
import com.employeeaudit.dto.EmployeeHistory;
import com.employeeaudit.process.EmployeeAuditDetailsProcess;

/**
 * Hello world!
 *
 */
public class EmployeeAuditClient 
{
    public static void main( String[] args )
    {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        ArrayList<Employee> empDetails = employeeDao.getEmployees();
        for (Employee employee : empDetails) {
        	System.out.println(employee);
		}
        EmployeeHistoryDaoImpl employeeHistoryDao = new EmployeeHistoryDaoImpl();
        ArrayList<EmployeeHistory> empHistoryDetails = employeeHistoryDao.getEmployeeHistory();
        for (EmployeeHistory employeeHistory : empHistoryDetails) {
			System.out.println(employeeHistory);
		}
        EmployeeAuditDetailsProcess employeeAuditDetailsProcess = new EmployeeAuditDetailsProcess();
        ArrayList<EmployeeAuditDetails> empAuditDetails = new ArrayList<EmployeeAuditDetails>();
        empAuditDetails = employeeAuditDetailsProcess.getEmployeeAuditDetails(empDetails, empHistoryDetails);
        for (EmployeeAuditDetails employeeAuditDetails : empAuditDetails) {
			System.out.println(empAuditDetails);
		}
    }
}
