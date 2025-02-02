package com.geek.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx1 {
public static void main(String[] args) {
	HashMap<String, String> map1=new HashMap<>();
	map1.put("E-101", "Raj");
	map1.put("E-102", "Karthik");
	map1.put("E-103", "Pooja");
	map1.put("E-104", "Sanjay");
	map1.put("E-101", "Raj Kumar"); //overwrites ....
	System.out.println(map1);
	
	System.out.println(map1.get("E-104"));
	System.out.println("E-104".hashCode());
	int hash="E-104".hashCode();
	int n=3;
	int slot=(n - 1) & hash;
	System.out.println(slot);
	System.out.println(map1.get("E-105"));
	///iterating a map ....
	//default map is not iterable
	System.out.println("-------------");
	Set<String> keys=  map1.keySet(); //returns set View
	keys.forEach(System.out::println);
	System.out.println("---------");
	Collection<String> values=   map1.values();
	values.forEach(System.out::println);
	System.out.println("-----------");
	Set<Entry<String, String>> records=map1.entrySet();
	for(Entry<String, String> r:records) {
		System.out.println(r.getKey()+" "+r.getValue());
	}
	
}
}
