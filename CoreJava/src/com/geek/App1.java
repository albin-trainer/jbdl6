package com.geek;
public class App1 {
	public static void main(String[] args) {
		//here p1 is the local ref variables
		Product p1=new Product();
	//	p1.prodId=101;
	//	p1.prodName="T shirt";
	//	p1.price=999.99f;
		p1.setProdId(101);
		p1.setProdName("T shirt");
		p1.setPrice(999.99f);
		System.out.println(p1.getProdId());
		System.out.println(p1.getProdName());
		System.out.println(p1.getPrice());
		modify(p1);
		System.out.println(p1.getPrice());
	}
	static void modify(Product p) {
		p.setPrice(1000);
	}
}
