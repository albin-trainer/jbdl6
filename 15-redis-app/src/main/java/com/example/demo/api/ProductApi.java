package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductApi {
	@Autowired
	private ProductService service;
	@PostMapping("/products")
	public Product save( @RequestBody Product p) {
		return service.save(p);
	}
	@GetMapping("/products/{id}")
	public Product searchById ( @PathVariable int id) {
		return service.searchById(id);
	}
	@GetMapping
	public List<Product> allProducts() {
		return service.allProducts();
	}
}
