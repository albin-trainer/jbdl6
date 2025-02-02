package com.geek.collections;
import java.util.TreeSet;
public class TreeSetEx2 {
public static void main(String[] args) {
	Employee e1=new Employee(101, "A");
	Employee e2=new Employee(102, "B");
	Employee e3=new Employee(103, "C");
	Employee e4=new Employee(104, "D");
	Employee e5=new Employee(101, "A");
	TreeSet<Employee> set=new TreeSet<>();
	set.add(e1); //internally compareTo gets called 
	set.add(e2);
	set.add(e3);
	set.add(e4);
	set.add(e5);
	System.out.println(set);
}
}
