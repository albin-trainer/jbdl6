package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
