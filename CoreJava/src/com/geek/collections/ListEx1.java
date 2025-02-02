package com.geek.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListEx1 {
public static void main(String[] args) {
	ArrayList<String> list=new ArrayList<>();
	list.add("Bangalore");
	list.add("Mysore");
	System.out.println(list);
	
	LinkedList<String> list2=new LinkedList<>();
	list2.add("Bangalore");
	list2.add("Mysore");
	System.out.println(list2);
	
	long t1=System.currentTimeMillis();
	for(int i=1;i<=100000;i++) {
		list.add(0,"hello");
	}
	long t2=System.currentTimeMillis();
	System.out.println("Time took for array list "+(t2-t1));
	
	
	t1=System.currentTimeMillis();
	for(int i=1;i<=100000;i++) {
		list2.add(0,"hello");
	}
	 t2=System.currentTimeMillis();
	System.out.println("Time took for LinkedList list "+(t2-t1));
	
}
}
