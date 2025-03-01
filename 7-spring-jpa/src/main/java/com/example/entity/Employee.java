package com.example.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity //maps with Employee table
@Table(name="emp")
public class Employee {
	@Id //PK
private int empId;
	@Column(name="ename",length = 20)
private String empName;
private LocalDate doj;
private float salary;
@Embedded
private Address address;//value obj

public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
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
public LocalDate getDoj() {
	return doj;
}
public void setDoj(LocalDate doj) {
	this.doj = doj;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}


}
