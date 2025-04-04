package com.example.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Order;

//@FeignClient(name = "myfeign",url = "http://localhost:9001")//no  load balancing
@FeignClient(name = "product-service") //with load balancing
public interface ProductProxy {
	@GetMapping("/products/{id}")
	Order getProduct(@PathVariable("id") int id);
}
