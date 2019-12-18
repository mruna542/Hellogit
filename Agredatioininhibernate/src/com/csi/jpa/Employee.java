/**
 * 
 */
package com.csi.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author Vaibhav
 *
 */
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	private String empName;
	private String empAddress;
	private double empSalary;
	public Employee(String empName, String empAddress, double empSalary) {
		super();
		this.empName = empName;
		this.empAddress = empAddress;
		this.empSalary = empSalary;
		
	}
	public Employee(){
		
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empAddress=" + empAddress + ", empSalary=" + empSalary + "]";
	}
	

}
