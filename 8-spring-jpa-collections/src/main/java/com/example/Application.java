package com.example;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dao.EmployeeDao;
import com.example.entity.Address;
import com.example.entity.Employee;
@SpringBootApplication
public class Application {
	static 	EmployeeDao dao;
	public static void main(String[] args) {
		 ApplicationContext ctx=  SpringApplication.run(Application.class, args);
		 dao=  ctx.getBean(EmployeeDao.class);
		//addEmp();
		 readEmp();
		
	}
	private static void readEmp() {
		dao.readEmp(102);
	}
	static void addEmp() {
		
		Employee e=new Employee(); 
		e.setEmpId(102);
		e.setEmpName("Raj");
		e.setSalary(50000);
		e.setDoj(LocalDate.of(2020, 10, 10));
		
		Address addr1=new Address();
		addr1.setDoorNo("A-101");
		addr1.setPlaceName("HSR");
		addr1.setPinCode(123456);
		
		Address addr2=new Address();
		addr2.setDoorNo("B-101");
		addr2.setPlaceName("Koramangala");
		addr2.setPinCode(5678990);
		List<Address> addressList=new ArrayList<>();
		addressList.add(addr1);addressList.add(addr2);
		e.setAddress(addressList);
		dao.addNewEmployee(e);
	}

}
