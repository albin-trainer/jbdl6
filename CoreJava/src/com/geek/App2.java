package com.geek;

public class App2 {
public static void main(String[] args) {
	Book b1=new Book();
	b1.setProdId(101);
	b1.setProdName("Harry Porter");
	b1.setPrice(500);
	b1.setAuthour("JK Rowlin");
	b1.setGenre("Fantacy");
	
	Apparal a1=new Apparal();
	a1.setProdId(102);
	a1.setProdName("Jeans");
	a1.setColor("Blue");
	a1.setPrice(1999.99f);
	a1.setFabric("Denim");
	
	Product items[]= {b1,a1};
	Cart cart=new Cart();
	cart.setItems(items);
	
	System.out.println("Items in the Cart");
	
	for(Product p:cart.getItems()) {
		p.display();
		//System.out.println(p.getAuthour());
		System.out.println("-----");
	}
	
}
}
