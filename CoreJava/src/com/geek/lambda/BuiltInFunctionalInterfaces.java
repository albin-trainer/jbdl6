package com.geek.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
public class BuiltInFunctionalInterfaces {
public static void main(String[] args) {
	ArrayList<Integer> list=new ArrayList<>();
	list.add(100);
	list.add(120);
	list.add(30);
	list.add(45);
	list.add(13);
	list.add(80);
	
	//Predicate<Integer> p=  (n)  ->  n%2!=0;
	//list.removeIf(p);
	list.removeIf((n)  ->  n%2!=0);
	System.out.println(list);
	
	Consumer<Integer> c= n->System.out.println(n);
	list.forEach(c);
	System.out.println("--------");
	list.forEach(n->System.out.println(n));
	
	Collections.sort(list);
	System.out.println(list);

}
}
