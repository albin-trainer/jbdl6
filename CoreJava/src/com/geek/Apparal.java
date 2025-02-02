package com.geek;

public class Apparal extends Product {
private String color;
private String fabric;
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getFabric() {
	return fabric;
}
public void setFabric(String fabric) {
	this.fabric = fabric;
}
public void display() {
	System.out.println("---Apparal---");
	super.display();
	System.out.println("Color : "+color);
	System.out.println("Fabric : "+fabric);
}

}
