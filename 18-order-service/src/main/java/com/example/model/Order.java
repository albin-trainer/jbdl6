package com.example.model;

import lombok.Data;

@Data
public class Order {
private int productId;
private String productName;
private float price;
private String port;
private int quantity;
}
