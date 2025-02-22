package com.example.demo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
private int prodId;
@NotBlank(message = "Product name is mandatory")
private String prodName;
@Min(value = 0,message = "Cannot be negative")
private float price;
@JsonFormat(pattern = "dd/MM/yyyy")
@PastOrPresent(message = "cant give future date")
private LocalDate manufactureDate;
public Product() {
	// TODO Auto-generated constructor stub
}


public Product(int prodId, String prodName, float price, LocalDate manufactureDate) {
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.price = price;
	this.manufactureDate = manufactureDate;
}


public Product(int prodId, String prodName, float price) {
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.price = price;
}


public LocalDate getManufactureDate() {
	return manufactureDate;
}


public void setManufactureDate(LocalDate manufactureDate) {
	this.manufactureDate = manufactureDate;
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
