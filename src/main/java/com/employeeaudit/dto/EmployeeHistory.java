package com.employeeaudit.dto;

import java.util.Date;

/*
 * DTO for Employee history details
 */
public class EmployeeHistory {
	private String empId;
	private String name;
	private Date SalaryCreditedDate;
	private int salary;
	
	public EmployeeHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeHistory(String empId, String name, Date SalaryCreditedDate, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.SalaryCreditedDate = SalaryCreditedDate;
		this.salary = salary;
	}
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
		return "EmployeeHistory [empId=" + empId + ", name=" + name + ", creditedDate=" + SalaryCreditedDate + ", salary="
				+ salary + "]";
	}
	
}
