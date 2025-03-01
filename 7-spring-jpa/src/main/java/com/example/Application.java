package com.example;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dao.EmployeeDao;
import com.example.entity.Address;
import com.example.entity.Employee;
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		 ApplicationContext ctx=  SpringApplication.run(Application.class, args);
		EmployeeDao dao=  ctx.getBean(EmployeeDao.class);
		Employee e=new Employee(); 
		e.setEmpId(102);
		e.setEmpName("Raj");
		e.setSalary(50000);
		e.setDoj(LocalDate.of(2020, 10, 10));
		
		Address addr=new Address();
		addr.setDoorNo("A-101");
		addr.setPlaceName("HSR");
		addr.setPinCode(123456);
		e.setAddress(addr);
		dao.addNewEmployee(e);
	}

}
