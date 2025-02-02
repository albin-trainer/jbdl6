package com.geek.lambda;

public class SimpleLambda {
public static void main(String[] args) {
	BirthDayWishes w=new BirthDayWishes();
	publish(w, "Raj");
	Greet g= (String n)->{return "Hello "+n+" wish u happy returns of the day !!!!";};
	publish(g, "Sanjay");
	publish((String n)->{return "Hello "+n+" wish u happy returns of the day !!!!";},"Rahul");
	
	publish(n->"Hello "+n,"All");
	
}
static void publish(Greet g,String name) {
	System.out.println(g.wish(name));
}
}
@FunctionalInterface
interface Greet{
	String wish(String name);
	//void f1();
}

class BirthDayWishes implements Greet{
	public String wish(String name) {
		return "Hi "+name+" Happy Bday";
	}
}