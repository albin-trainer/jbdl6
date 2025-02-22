package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

//@Component
@Service
public class ProductService {
	List<Product> list= new ArrayList<>();
  public ProductService() {
	  //assume these data pulled from DB
	 list.add(new Product(101, "Mobile", 20000,LocalDate.of(2025, 1, 10)));
	 list.add(new Product(102, "T shirt", 1000,LocalDate.of(2023, 2, 20)));
	 list.add(new Product(103, "Jeans", 4000,LocalDate.of(2021, 10, 1)));
	 list.add(new Product(104, "Mouse", 2000,LocalDate.of(2020, 1, 10)));
	 list.add(new Product(105, "Laptop", 50000,LocalDate.of(2020, 1, 10)));
}
	
	public List<Product> allProducts(){
		return list;
	}
}
