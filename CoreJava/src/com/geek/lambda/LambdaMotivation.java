package com.geek.lambda;

import java.util.ArrayList;
import java.util.List;
public class LambdaMotivation {
public static void main(String[] args) {
	Product p1=new Product(101,"Laptop",50000,4.4f);
	Product p2=new Product(102,"Head phones",2000,4.5f);
	Product p3=new Product(103,"Mouse",1000,3.7f);
	Product p4=new Product(104,"T shirt",1000,4.9f);
	Product p5=new Product(105,"Jeans",3000,5);
	ArrayList<Product> list=new ArrayList<>();
	list.add(p1);list.add(p2);list.add(p3);list.add(p4);list.add(p5);
	filterProductsAndDisplay(list, new ProductFitlerByRatings());
	System.out.println("***********************");
	filterProductsAndDisplay(list, p->p.getPrice()<=10000);
	filterProductsAndDisplay(list, p->p.getPrice()<=10000 && p.getRatings()>4);
}
   static void filterProductsAndDisplay(List<Product> plist,ProductFilter filter) {
	   for(Product p:plist) {
		 //  if(p.getRatings()>=4.0) {
		   if(filter.test(p)) {
			   System.out.println(p.getProdName());
		   }
	   }
   }
}

class Product{
	private int prodId;
	private String prodName;
	private float price;
	private float ratings;
	public Product(int prodId, String prodName, float price, float ratings) {
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price; this.ratings=ratings;
	}
	
	
	public float getRatings() {
		return ratings;
	}


	public void setRatings(float ratings) {
		this.ratings = ratings;
	}


	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}