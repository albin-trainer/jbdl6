package com.g;

import com.g2.HelloApp;
import com.g3.App3;

public class Main {
public static void main(String[] args) {
	HelloApp h=new HelloApp();
	System.out.println(h.getData());
	//Transitive dependencies.....
	App3 ap=new App3();
	System.out.println(ap.hello());
}
}
