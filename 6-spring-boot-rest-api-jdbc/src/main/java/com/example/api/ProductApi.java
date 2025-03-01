package com.example.api;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.exception.ProductNotFoundException;
import com.example.service.ProductService;

import jakarta.validation.Valid;


@RestController//combination of @Controller and @ResponseBody
//@Controller
@RequestMapping("/products")
public class ProductApi {
	@Autowired
	private ProductService service;
	
//	@GetMapping( produces = "text/html")
//	public String test() {
//		return "<font color=blue size=10>Hello</font>";
//	}
	@GetMapping("/sample")
	@ResponseBody
	public Product sampleProduct() {
		return new Product(101, "Briyani", 200);
	}
		@GetMapping
	public List<Product> allProducts(){
		return service.allProducts();
	}
		@GetMapping(value =   "/{pid}",produces = {"application/json","application/xml "} )
    public Product searchById(@PathVariable("pid")  int id) {
		return service.searchById(id);
    }
		@PostMapping(consumes = {"application/xml","application/json"}, 
				produces ={"application/xml","application/json"} )
		public ResponseEntity<Product> addNewProduct( @RequestBody @Valid  Product p) {
			service.addNewProductService(p);
			return new ResponseEntity<>(p,HttpStatus.CREATED);
		}
		@GetMapping("/searchbyprice")
		public   ResponseEntity<List<Product>> searchByPrice(@RequestParam  float maxPrice,@RequestParam float minPrice){
			List<Product> list=service.allProducts();
			list=list.stream().filter(p->p.getPrice()<=maxPrice && p.getPrice()>=minPrice).toList();
			if(list.size()==0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return  new ResponseEntity<>(list,HttpStatus.OK);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Product> updateProduct( @RequestBody @Valid  Product p, @PathVariable int id) {
			return null;
		}
		@DeleteMapping("/{id}")
		public  ResponseEntity<Void> delete(@PathVariable int id) {
			service.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
}
