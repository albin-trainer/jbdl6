package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
private int empId;
private String empName;
@ManyToOne
@JoinColumn(name="dept_id")//optional for FK
private Department dept;

public Department getDept() {
	return dept;
}
public void setDept(Department dept) {
	this.dept = dept;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}


}
