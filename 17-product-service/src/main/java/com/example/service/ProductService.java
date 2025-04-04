package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.model.Product;

@Service
public class ProductService {
	@Autowired
private Environment env;
	
	public List<Product> allProducts(){
		String port=env.getProperty("local.server.port");
		//Assume these data pulled from the DB ....
		Product p1=new Product(101, "T Shirt", 700, port);
		Product p2=new Product(102, "JEans", 2000, port);
		Product p3=new Product(103, "Mobile", 10000, port);
		Product p4=new Product(104, "Toy", 1000, port);
		Product p5=new Product(105, "Bottle", 500, port);
		List<Product> list=Arrays.asList(p1,p2,p3,p4,p5);
		return list;
	}
	
}
