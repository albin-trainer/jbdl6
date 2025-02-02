package com.geek.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx2 {
public static void main(String[] args) {
	//find the sum of even nos
	//Stream.of(1,2,3,4,5,6).filter(n->n%2==0).
	
	int s=IntStream.of(1,2,3,4,5).filter(n->n%2==0).sum();
	System.out.println(s);
	
	//MapToInt method create a new Int Stream and return it ..
	s=Stream.of(1,2,3,4,5,6).filter(n->n%2==0).mapToInt(n->n).sum();
	System.out.println(s);
	
	//Stream<Character> str=  Stream.of('A','B','C','D');
	String s2="Hello";
	char ch[]=s2.toCharArray();
	Stream<char[]> str2=Stream.of(ch);
	
Arrays.st
}
}
