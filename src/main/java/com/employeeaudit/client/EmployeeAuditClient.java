package com.employeeaudit.client;

import java.util.ArrayList;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.employeeaudit.dao.EmployeeDaoImpl;
import com.employeeaudit.dao.EmployeeHistoryDaoImpl;
import com.employeeaudit.dao.HeadersDaoImpl;
import com.employeeaudit.dto.Employee;
import com.employeeaudit.dto.EmployeeAuditDetails;
import com.employeeaudit.dto.EmployeeHistory;
import com.employeeaudit.dto.Headers;
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

        EmployeeHistoryDaoImpl employeeHistoryDao = new EmployeeHistoryDaoImpl();
        ArrayList<EmployeeHistory> empHistoryDetails = employeeHistoryDao.getEmployeeHistory();

        EmployeeAuditDetailsProcess employeeAuditDetailsProcess = new EmployeeAuditDetailsProcess();
        ArrayList<EmployeeAuditDetails> empAuditDetails = employeeAuditDetailsProcess.getEmployeeAuditDetails(empDetails, empHistoryDetails);
        
        String headersFilePath = "C:\\Users\\45228\\eclipse-workspace\\employeeaudit\\assets\\header.properties";
        
        HeadersDaoImpl headersDaoImpl = new HeadersDaoImpl();
        Headers headers = headersDaoImpl.getHeaders(headersFilePath);
        String excelFilePath = employeeAuditDetailsProcess.generateExcelReport(headers, empAuditDetails);
        
        try {
			Desktop.getDesktop().open(new File(excelFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not available");
		}
    }
}
