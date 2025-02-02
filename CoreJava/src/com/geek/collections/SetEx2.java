package com.geek.collections;
import java.util.HashSet;
public class SetEx2 {
public static void main(String[] args) {
	Employee e1=new Employee(101, "A");
	Employee e2=new Employee(102, "B");
	Employee e3=new Employee(103, "C");
	Employee e4=new Employee(104, "D");
	Employee e5=new Employee(101, "A");
	HashSet<Employee> set=new HashSet<>();
	set.add(e1);set.add(e2);set.add(e5);set.add(e3);set.add(e4);
	System.out.println("No of elements is "+set.size());
	//System.out.println(e1.hashCode());
	//System.out.println(e5.hashCode());
	//System.out.println(e1.equals(e5));
}
}