package com.example.dao;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductDao {
Product addNewProduct(Product p);

List<Product> allProducts();

Product searchById(int productId);

void deleteProduct(int productId);

}
