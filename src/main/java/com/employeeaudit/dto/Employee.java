package com.employeeaudit.dto;

import java.util.Date;


/**
 * @author 45228
 * DTO for Employee details
 */
public class Employee {
	private String empId;
	private String name;
	private Date doj;
	private int salary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public Date getDoj() {
		return doj;
	}
	
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Employee(String empId, String name, Date doj, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.doj = doj;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", doj=" + doj + ", salary=" + salary + "]";
	}
}
