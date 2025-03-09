package com.geek;

import com.geek.exception.InvalidInputException;

public class Calculator {
	public Calculator() {
		System.out.println("constructor ...");
	}
	
	public int add(int x,int y) {
		return x+y;
	}
 public int add(int ...nums) {
	 int s=0;
	 for(int x:nums) {
		 s=x+s;
	 }
	 return s;
 }
 public int product(int ...nums) {
	 int s=1;
	 for(int x:nums) {
		 s=x*s;
	 }
	 return s;
 }
 public int div(int a,int b) {
	 if(b==0)
		 throw new InvalidInputException("Will not accept zero");
	 return a/b;
 }
 
 
 public static void main(String[] args) {
	Calculator c=new Calculator();
	System.out.println(c.add(1,2,3,4,5));
	System.out.println(c.product(1,2,3,4,5));
}
}
