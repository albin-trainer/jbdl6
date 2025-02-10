package com.geek.streams;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamEx3 {
public static void main(String[] args) {
Product p1=new Product(101, "Laptop", 50000, 4.5f)	;
Product p2=new Product(102, "Mobile", 20000, 4.1f)	;
Product p3=new Product(103, "T Shirt", 1000, 4.9f)	;
Product p4=new Product(104, "Biscuit", 50, 4.2f)	;
Product p5=new Product(105, "Maggi", 90, 3.5f)	;
List<Product> list=new ArrayList<>();
list.add(p1);list.add(p2);list.add(p3);list.add(p4);list.add(p5);
/*
 * float total=0; for(Product p:list) { total=total+p.getPrice(); }
 */
 double sum=  list.stream().mapToDouble(p->p.getPrice()).sum();
 System.out.println(sum);
   Product p=  findCostliest(list.stream());
   System.out.println(p); //println method internally invokes toString()
   System.out.println(p.toString());
   List<Product> highlyRatedProducts=
   list.stream().filter(pr->pr.getRatings()>=4.5).toList(); //from java 16
   
   //Prior to java 16
   highlyRatedProducts=
		   list.stream().filter(pr->pr.getRatings()>=4.5).collect(Collectors.toList());
   
  Map<String, Float> map=
   list.stream().filter(pr->pr.getRatings()>=4.5).
   collect(Collectors.toMap(pr->pr.getProdName(), pr->pr.getRatings()));
  System.out.println(map);
   
}

static Product findCostliest(Stream<Product>  stream ) {
	  Optional<Product> p=stream.max( (p1,p2)->p1.getPrice()<p2.getPrice()?-1:1);
	  if(p.isPresent()) {
		  return p.get();
	  }
	throw new RuntimeException("Empty");
}
}
