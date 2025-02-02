package com.geek.lambda;
import java.util.ArrayList;
import java.util.function.Consumer;
public class MethodReferenceEx2 {
public static void main(String[] args) {
	ArrayList<Integer> list=new ArrayList<>();
	list.add(10);
	list.add(20);
	list.add(30);
	list.add(40);
	list.add(50);
//	Consumer<Integer> c=(n)->System.out.println(n+"****");
	list.forEach(n -> System.out.println(n));
	System.out.println("------------");
	//since method signature of println and Consumer's accept methods are same
	list.forEach(System.out::println); 
}
}
