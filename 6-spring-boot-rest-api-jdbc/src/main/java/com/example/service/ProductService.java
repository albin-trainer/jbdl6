package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDao;
import com.example.demo.model.Product;
import com.example.exception.ProductNotFoundException;

//@Component
@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	
  public ProductService() {
	  
	
}
	
	public List<Product> allProducts(){
		return dao.allProducts();
	}
	public  Product addNewProductService(Product p) {
		return dao.addNewProduct(p);
	}
	public Product searchById(int productId) {
		Product p= dao.searchById(productId);
		if(p==null) {
			throw new ProductNotFoundException("Product id "+productId+" not found");
		}
		return p;
	}
	public void deleteProduct(int productId) {
		Product p=searchById(productId);
	   dao.deleteProduct(productId);
	}
	
}
