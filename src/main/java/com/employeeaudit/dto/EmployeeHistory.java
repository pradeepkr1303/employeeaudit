package com.employeeaudit.dto;

import java.util.Date;


/**
 * @author 45228
 * DTO class for employee History
 */
public class EmployeeHistory {
	private String empId;
	private Date SalaryCreditedDate;
	private int salary;
	
	public EmployeeHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeHistory(String empId, Date SalaryCreditedDate, int salary) {
		super();
		this.empId = empId;
		this.SalaryCreditedDate = SalaryCreditedDate;
		this.salary = salary;
	}
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public Date getSalaryCreditedDate() {
		return SalaryCreditedDate;
	}
	
	public void setSalaryCreditedDate(Date creditedDate) {
		this.SalaryCreditedDate = creditedDate;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeHistory [empId=" + empId + ", creditedDate=" + SalaryCreditedDate + ", salary="
				+ salary + "]";
	}
	
}
