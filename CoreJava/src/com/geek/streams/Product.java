package com.geek.streams;
public class Product {
	//instance variables (class level)
	private int prodId;
	private String prodName;
	private float price;
	private float ratings;
	
	public Product(int prodId, String prodName, float price, float ratings) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
		this.ratings = ratings;
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
	public void display() {
		System.out.println("ProdId "+prodId);
		System.out.println("Prod Name "+prodName);
		System.out.println("Price : "+price);
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", ratings=" + ratings
				+ "]";
	}
	
//	public void setProdId(int id) {
//		//here i can do validations
//		prodId=id;
//	}
	
}
