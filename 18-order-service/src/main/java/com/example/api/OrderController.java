package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Order;
import com.example.proxy.ProductProxy;

@RestController
public class OrderController {
   @PostMapping("/order/{prodId}/{q}")
	public Order orderProduct(@PathVariable("prodId") int prodId, @PathVariable("q") int q) {
	   String url="http://localhost:9002/products/"+prodId;
	   RestTemplate template= new RestTemplate();
	    //making a rest call to another service
	   Order order= template.getForObject(url,Order.class);
		return order;
	}
   @Autowired
   RestTemplate template;
   @PostMapping("/orderloadbal/{prodId}/{q}")
  	public Order orderProductLoadBal(@PathVariable("prodId") int prodId, @PathVariable("q") int q) {
  	   String url="http://product-service/products/"+prodId;
  	   Order order= template.getForObject(url,Order.class);
  		return order;
  	}
   @Autowired
   ProductProxy proxy;
   @PostMapping("/feign/{prodId}/{q}")
 	public Order orderProductByFeign(@PathVariable("prodId") int prodId, @PathVariable("q") int q) {
 	   Order order= proxy.getProduct(prodId);
 	   return order;
 	}
	
}
