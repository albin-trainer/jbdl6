package com.geek.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class SortDemo {
public static void main(String[] args) {
	Product p1=new Product(101,"Laptop",50000,4.4f);
	Product p2=new Product(102,"Head phones",2000,4.5f);
	Product p3=new Product(103,"Mouse",1000,3.7f);
	Product p4=new Product(104,"T shirt",1000,4.9f);
	Product p5=new Product(105,"Jeans",3000,5);
	ArrayList<Product> list=new ArrayList<>();
	list.add(p1);list.add(p2);list.add(p3);list.add(p4);list.add(p5);
	list.forEach(p->System.out.println(p.getProdName()+" "+p.getPrice()+" "+p.getRatings()));
	Collections.sort(list, new SortByRatings());
	System.out.println("****After sorting ****");
	list.forEach(p->System.out.println(p.getProdName()+" "+p.getPrice()+" "+p.getRatings()));
    Collections.sort(list, (o1,o2)->o1.getRatings()<o2.getRatings()?1:-1);
}
}
class SortByRatings implements Comparator<Product>{
	//this method returns either -ve or +ve
	public int compare(Product o1, Product o2) {
		return o1.getRatings()<o2.getRatings()?1:-1;
	}
}