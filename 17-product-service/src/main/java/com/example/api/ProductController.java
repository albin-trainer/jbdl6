package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Product;
import com.example.service.ProductService;
@RestController
public class ProductController {
	@Autowired
private ProductService service;
  @GetMapping("/products")
	public List<Product> allProducts(){
		return service.allProducts();
	}
  @GetMapping("/products/{id}")
  public Product searchById( @PathVariable("id") int id) {
	  List<Product> list=service.allProducts();
	  Product product=
	  list.stream().filter(p->p.getProductId()==id).findFirst().get();
	  return product;
  }

}
