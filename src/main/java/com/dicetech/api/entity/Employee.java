package com.dicetech.api.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srNo;
	
	private long empId;
	private String empName;
	private String address;
	private String mobileNo;
	private String emailId;
	private Date joinDate;
	
	
    public Employee() {
		
	}

	public Employee(int srNo, long empId, String empName, String address, String mobileNo, String emailId, Date joinDate) {
		this.srNo = srNo;
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.joinDate = joinDate;
	}


	public int getSrNo() {
		return srNo;
	}

	public long getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getAddress() {
		return address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public Date getJoinDate() {
		return joinDate;
	}


	

}

