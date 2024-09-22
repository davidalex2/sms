package com.algoriant.model;

import java.sql.Date;

public class Student {
	
	private int id;
	private String name,dept;
	private Date dob;
	public void Student(int id,String name,String dept,Date dob) {
		this.name=name;	
		this.id=id;
		this.dept=dept;
		this.dob=dob;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setDept(String dept) {
		this.dept=dept;
	}
	public String getDept() {
		return dept;
	}
	public void setDob(Date dob) {
		this.dob=dob;
	}
	public Date getDob() {
		return dob;
	}
}	