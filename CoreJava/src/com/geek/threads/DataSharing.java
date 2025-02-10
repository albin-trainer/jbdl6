package com.geek.threads;

public class DataSharing {
public static void main(String[] args) throws InterruptedException {
	Data d=new Data();
	Thread t1=new Thread(d);
	Thread t2=new Thread(d);
	Thread t3=new Thread(d);
	t1.start();
	t2.start();
	t3.start();
	//now getVal method gets called before threads started
	//running
	t1.join();
	t2.join();
	t3.join();
	System.out.println(d.getVal()); 
}
}
class Data implements Runnable{
	private int c=0;
	public void run() {
		for(int i=1;i<=10000;i++) {
			synchronized(this) {
					c++; 
			}
		}
		System.out.println("Completed");
	}
	public int getVal() {
		return c;
	}
	
}