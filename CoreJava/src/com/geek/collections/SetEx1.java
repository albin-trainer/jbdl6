package com.geek.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetEx1 {
	//List --> permits duplicate elements
	//Set--> Never permits duplicates
	
public static void main(String[] args) {
	 //No duplicates
	 //no guaranty for order
	HashSet<String> set1= new HashSet<>();
	set1.add("Bangalore");
	set1.add("Mysore");
	set1.add("Chennai");
	set1.add("Pune");
	set1.add("Bangalore");
	System.out.println(set1);
	//no duplicates
	//sorted order 
	TreeSet<String> set2= new TreeSet<>();
	set2.add("Bangalore");
	set2.add("Mysore");
	set2.add("Chennai");
	set2.add("Pune");
	set2.add("Bangalore");
	System.out.println(set2);
	
	//no duplicates
	//insertion order 
	LinkedHashSet<String> set3= new LinkedHashSet<>();
	set3.add("Bangalore");
	set3.add("Mysore");
	set3.add("Chennai");
	set3.add("Pune");
	set3.add("Bangalore");
	System.out.println(set3);
}
}
