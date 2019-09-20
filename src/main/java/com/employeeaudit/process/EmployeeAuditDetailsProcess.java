package com.employeeaudit.process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.employeeaudit.dto.Employee;
import com.employeeaudit.dto.EmployeeAuditDetails;
import com.employeeaudit.dto.EmployeeHistory;
import com.employeeaudit.dto.Headers;

public class EmployeeAuditDetailsProcess {
	public ArrayList<EmployeeAuditDetails> getEmployeeAuditDetails(ArrayList<Employee> employeeDetails,
			ArrayList<EmployeeHistory> employeeHistoryDetails) {
		ArrayList<EmployeeAuditDetails> empAuditDetails = new ArrayList<EmployeeAuditDetails>();
		Employee tempEmp = null;
		ArrayList<EmployeeHistory> tempHistory = null;

		for (Employee employeeDetail : employeeDetails) {
			tempEmp = employeeDetail;
			tempHistory = new ArrayList<EmployeeHistory>();
			for (EmployeeHistory employeeHistory : employeeHistoryDetails) {
				if (tempEmp.getEmpId().equals(employeeHistory.getEmpId())) {

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

	public String generateExcelReport(Headers headers, ArrayList<EmployeeAuditDetails> empAuditDetails) {
		String excelFilePath = "";

		@SuppressWarnings("resource")
		XSSFWorkbook empWorkBook = new XSSFWorkbook();
		XSSFSheet empData = empWorkBook.createSheet("EMP DATA");
		XSSFRow row;
		int rowid = 0;
		int cellid = 0;

		row = empData.createRow(rowid++);
		Cell cell = row.createCell(cellid++);
		cell.setCellValue(headers.getHeader1());
		cell = row.createCell(cellid++);
		cell.setCellValue(headers.getHeader2());
		cell = row.createCell(cellid++);
		cell.setCellValue(headers.getHeader3());
		cell = row.createCell(cellid++);
		cell.setCellValue(headers.getHeader4());
		cellid = 0;

		try {
			
			for (EmployeeAuditDetails employeeAuditDetail : empAuditDetails) {
				Employee temp = employeeAuditDetail.getEmployee();
				row = empData.createRow(rowid++);
				cell = row.createCell(cellid++);
				cell.setCellValue(temp.getEmpId());
				cell = row.createCell(cellid++);
				cell.setCellValue(temp.getName());
				cell = row.createCell(cellid++);
				cell.setCellValue(temp.getDoj());
				cell = row.createCell(cellid++);
				cell.setCellValue(temp.getSalary());
				cellid = 0;
				
				for (EmployeeHistory employeeHitory : employeeAuditDetail.getEmployeeHistory()) {
					row = empData.createRow(rowid++);
					cell = row.createCell(cellid++);
					cell.setCellValue(employeeHitory.getEmpId());
					cell = row.createCell(cellid++);
					cell.setCellValue(employeeHitory.getName());
					cell = row.createCell(cellid++);
					cell.setCellValue(employeeHitory.getSalaryCreditedDate());
					cell = row.createCell(cellid++);
					cell.setCellValue(employeeHitory.getSalary());
					cellid = 0;
				}
			}

//			while (empDetailsIter.hasNext()) {
//				EmployeeDetails temp = empDetailsIter.next();
//				row = empData.createRow(rowid++);
//				cell = row.createCell(cellid++);
//				cell.setCellValue(temp.getEmpId());
//				cell = row.createCell(cellid++);
//				cell.setCellValue(temp.getName());
//				cell = row.createCell(cellid++);
//				cell.setCellValue(temp.getDoj());
//				cell = row.createCell(cellid++);
//				cell.setCellValue(temp.getSalary());
//				cellid = 0;
//			}

			FileOutputStream out = new FileOutputStream(new File("./assets/empAuditData.xlsx"));
			empWorkBook.write(out);
			out.close();
			excelFilePath = "./assets/empAuditData.xlsx";

		} catch (IOException e) {
			e.printStackTrace();
		}

		return excelFilePath;
	}
}
