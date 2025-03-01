package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.validation.Valid;
@Component
public class DBConnection {
	@Value("${db.driver}")
	private String driverClass;
	@Value("${db.url}")
	private String url;
	@Value("${db.uname}")
	private String uname;
	@Value("${db.pwd}")
	private String pwd;
	public   Connection getConnection() {
		 //load the driver
		Connection con=null;
		try {
			Class.forName(driverClass);
			//to make connection
			//need url, uname and pwd
			//http://domainname:portno
			 //establish the connection
			 con= DriverManager.getConnection(url,uname,pwd);
			 System.out.println("Connection success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return connection
		return con;
	}
}
