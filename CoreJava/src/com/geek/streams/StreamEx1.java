package com.geek.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class StreamEx1 {
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8);
		for(int a:list) {
			if(a%2==0) {
				System.out.println(a);
			}
		}
		System.out.println("------------");
		//Stream<Integer> st1= list.stream();
		list.stream().filter(n->n%2==0).filter(n->n>2).forEach(n->System.out.println(n));
	}

}
