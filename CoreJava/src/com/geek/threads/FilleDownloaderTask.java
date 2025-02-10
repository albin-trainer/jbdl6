package com.geek.threads;
public class FilleDownloaderTask implements Runnable{
	public void run() {
		Thread t=Thread.currentThread(); //returns current running thread
		System.out.println(t.getName()+" Child thread started running");
		for(int i=1;i<=1000;i++) {
			System.out.println("CHILD : "+i);
		}
	}
}
