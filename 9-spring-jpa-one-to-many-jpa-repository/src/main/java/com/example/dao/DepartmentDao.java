package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Department;

public interface DepartmentDao  extends JpaRepository<Department, Integer>{
	//query method syntax : findBy<FieldName>
	List<Department> findByDeptName(String dname);
}
