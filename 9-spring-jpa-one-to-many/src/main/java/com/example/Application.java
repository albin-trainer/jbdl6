package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dao.DepartmentDao;
import com.example.entity.Department;
import com.example.entity.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx=
		SpringApplication.run(Application.class, args);
		DepartmentDao dao=
				ctx.getBean(DepartmentDao.class);
		/*Department d= new Department();
		d.setDeptId(100002);
		d.setDeptName("HR");
		dao.addDepartment(d);*/
		/*
		 * Employee e=new Employee(); e.setEmpId(102); e.setEmpName("avinash");
		 * dao.addEmployee(e, 100009);
		 */
		//dao.searchEmp(101);
		/*Department d= new Department();
		d.setDeptId(100004);
		d.setDeptName("Transport");
		Employee e1=new Employee();
		e1.setEmpId(1);
		e1.setEmpName("A");
		e1.setDept(d);
		Employee e2=new Employee();
		e2.setEmpId(2);
		e2.setEmpName("B");
		e2.setDept(d);
		List<Employee> emps=new ArrayList<>();
		emps.add(e1);emps.add(e2);
		d.setEmps(emps);
		dao.addDepartment(d);
		*/
		//dao.getAllDepts();
		dao.searchDeptByName("Marketting");
	}

	
}
