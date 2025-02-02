package com.geek;
public class Product {
	//instance variables (class level)
	private int prodId;
	private String prodName;
	private float price;
	
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
	public void display() {
		System.out.println("ProdId "+prodId);
		System.out.println("Prod Name "+prodName);
		System.out.println("Price : "+price);
	}
	
//	public void setProdId(int id) {
//		//here i can do validations
//		prodId=id;
//	}
	
}
