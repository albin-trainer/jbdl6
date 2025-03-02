package com.example.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Department;
import com.example.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Component
@Transactional
public class DepartmentDao {
	@PersistenceContext 
	private EntityManager em;
public void addDepartment(Department d) {
	em.persist(d);
	System.out.println("Department added");
}
public void addEmployee(Employee e, int deptId) {
	Department d=em.find(Department.class, deptId);
	if(d!=null) {
		e.setDept(d);
		em.persist(e);
		System.out.println("Emp added");
	}
	else
	System.out.println("Dept not exist");
}

public void searchEmp(int eid) {
	Employee e=
	em.find(Employee.class, eid);
	if(e!=null) {
		System.out.println(e.getEmpId());
		System.out.println(e.getEmpName());
		Department d=e.getDept();
		System.out.println("working in "+d.getDeptName());
	}
}
public void getAllDepts() {
	String jpql="select d from Department d";
	Query q=  em.createQuery(jpql);
      List<Department>depts=q.getResultList();
      depts.forEach(d->System.out.println(d.getDeptName()+" "+d.getDeptId()));
}
public void searchDeptByName(String dname) {
//	String jpql="select d from Department d where d.deptName= :n";
	Query q=  em.createNamedQuery("searchByName");
	q.setParameter("n", dname);
      List<Department>depts=q.getResultList();
      depts.forEach(d->System.out.println(d.getDeptName()+" "+d.getDeptId()));
}

}
