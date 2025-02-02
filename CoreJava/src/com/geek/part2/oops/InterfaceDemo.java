package com.geek.part2.oops;

public class InterfaceDemo {
public static void main(String[] args) {
	Drive driver=getCar("BMW");
	driver.accelerator(); driver.steering();
}
static Drive getCar(String car) {
	if(car.equals("BMW")) return new BMW();
	else return new Alto();
}
}
interface Drive{
	void steering(); //public abstract void steering();
	void accelerator();
}
class BMW implements Drive{
	public void steering() {
		System.out.println("BMW steering works");
	}
	public void accelerator() {
		System.out.println("BMW accerlator works");
	}
}
class Alto implements Drive{
	public void steering() {
		System.out.println("Alto steering works");
	}
	public void accelerator() {
		System.out.println("Alto accerlator works");
	}
}