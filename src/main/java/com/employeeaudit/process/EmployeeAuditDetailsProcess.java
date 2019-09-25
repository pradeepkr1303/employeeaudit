package com.employeeaudit.process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.employeeaudit.dto.Employee;
import com.employeeaudit.dto.EmployeeAuditDetails;
import com.employeeaudit.dto.EmployeeHistory;
import com.employeeaudit.dto.Headers;

/**
 * @author 45228
 * This class is to process all the business logics.
 */
/**
 * @author 45228
 *
 */
public class EmployeeAuditDetailsProcess {
	/**
	 * @param employeeDetails contains the records of employee retrieved from DB.
	 * @param employeeHistoryDetails contains the history of employee retrieved from DB.
	 * @return the data of type EmployeeAuditDetails combined from Employee and EmployeeHistory.
	 */
	public ArrayList<EmployeeAuditDetails> getEmployeeAuditDetails(ArrayList<Employee> employeeDetails,
			ArrayList<EmployeeHistory> employeeHistoryDetails) {
		ArrayList<EmployeeAuditDetails> empAuditDetails = new ArrayList<EmployeeAuditDetails>();
		Employee tempEmp = null;
		ArrayList<EmployeeHistory> tempHistory = null;
		
		employeeDetails = sortEmployee(employeeDetails);

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

	/**
	 * @param employeeDetails contains the records of employee.
	 * @return the sorted Array list of employee
	 */
	public ArrayList<Employee> sortEmployee(ArrayList<Employee> employeeDetails) {
		
		Comparator<Employee> sortByName = Comparator.comparing(Employee::getName).thenComparing(Employee::getEmpId);
		employeeDetails.sort(sortByName);

		return employeeDetails;
	}

	/**
	 * @param headers contains the header fields needed to generate excel report.
	 * @param empAuditDetails contains both employee details including history.
	 * @return the string which points the file path of generated excel file.
	 */
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
				DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");  
				String doj = dateFormat.format(temp.getDoj()); 
				row = empData.createRow(rowid++);
				cell = row.createCell(cellid++);
				cell.setCellValue(temp.getEmpId());
				cell = row.createCell(cellid++);
				cell.setCellValue(temp.getName());
				cell = row.createCell(cellid++);
				cell.setCellValue(doj);
				cell = row.createCell(cellid++);
				cell.setCellValue(temp.getSalary());
				cellid = 0;
				
				for (EmployeeHistory employeeHitory : employeeAuditDetail.getEmployeeHistory()) {
					String credited_date = dateFormat.format(employeeHitory.getSalaryCreditedDate());
					row = empData.createRow(rowid++);
					cell = row.createCell(cellid++);
					cell.setCellValue(employeeHitory.getEmpId());
					cell = row.createCell(cellid++);
					cell.setCellValue(temp.getName());
					cell = row.createCell(cellid++);
					cell.setCellValue(credited_date);
					cell = row.createCell(cellid++);
					cell.setCellValue(employeeHitory.getSalary());
					cellid = 0;
				}
			}
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
