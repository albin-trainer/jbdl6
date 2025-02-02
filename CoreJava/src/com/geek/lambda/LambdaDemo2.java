package com.geek.lambda;

public class LambdaDemo2 {
public static void main(String[] args) {
	Calculator c= (float a,float b)->{return a+b;};
	System.out.println(c.eval(10, 9));
	Calculator c2=(x,y)->x*y;
	System.out.println(c2.eval(10, 9));
}
}
interface Calculator{
	float eval(float a,float b);
}