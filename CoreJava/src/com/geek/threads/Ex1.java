package com.geek.threads;
public class Ex1 {
public static void main(String[] args) {
	Thread t=Thread.currentThread(); //returns current running thread
	System.out.println(t.getName()+" is the current running thread");
	FilleDownloaderTask downloader= new FilleDownloaderTask();
	Thread thread=new Thread(downloader);
	thread.start(); //Runnable state (Cant predict)
	for(int i=1;i<=1000;i++) {
		System.out.println("MAIN : "+i);
	}
	hello();
	System.out.println("MAIN ENDS ....");
}
static void hello() {
	Thread t=Thread.currentThread(); //returns current running thread
	System.out.println(t.getName()+" is the current running thread");
	
}
}

