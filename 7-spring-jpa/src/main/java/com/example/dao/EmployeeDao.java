package com.example.dao;

import org.springframework.stereotype.Component;

import com.example.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Component
public class EmployeeDao {
	@PersistenceContext
	private EntityManager em; //responsible for managing entities (CRUD operations)
	
	@Transactional
	public Employee addNewEmployee(Employee e) {
		em.persist(e);
		//other persist operations
		//update/delete ..
		System.out.println("SAVED .....");
		return e;
	} //commmit 
}
