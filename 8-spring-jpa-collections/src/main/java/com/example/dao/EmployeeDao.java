package com.example.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Address;
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
	
	
	public void readEmp(int eid) {
	  Employee emp=	em.find(Employee.class, eid);
	  if(emp!=null) {
	  System.out.println("E id : "+emp.getEmpId());
	  System.out.println("Ename : "+emp.getEmpName());
	   //returns proxy
	  List<Address> addrs=  emp.getAddress();
	  System.out.println("----------------");
	  addrs.forEach(a->System.out.println(a.getDoorNo()+" "+a.getPlaceName()));
	  }
	}
}
