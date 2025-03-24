package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;
@Service
public class ProductService {
	@Autowired
private ProductRepo repo;
	@CachePut(key="#p.pid",value="product")
	public Product save(Product p) {
		return repo.save(p);
	}
	//1st time it must store in cache 
	//and from next time read from the cache
	@Cacheable(key = "#id",value = "product")
	public Product searchById(int id) {
		return repo.findById(id).get();
	}
	@Cacheable(value = "allProducts")
	public List<Product> allProducts() {
		return repo.findAll();
	}
	@CacheEvict(key= "#id",value = "product")
	public void removeProduct(int id) {
		repo.deleteById(id);
	}
	
	
}
