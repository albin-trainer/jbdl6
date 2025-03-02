package com.example.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
@Entity
@NamedQuery(query = "select d from Department d where d.deptName= :n",name = "searchByName")
public class Department {
	@Id
private int deptId;
private String deptName;
@OneToMany(mappedBy = "dept",
cascade = CascadeType.PERSIST)//inverse side
private List<Employee> emps;

public List<Employee> getEmps() {
	return emps;
}
public void setEmps(List<Employee> emps) {
	this.emps = emps;
}
public int getDeptId() {
	return deptId;
}
public void setDeptId(int deptId) {
	this.deptId = deptId;
}
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}

}
