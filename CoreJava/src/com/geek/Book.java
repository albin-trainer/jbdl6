package com.geek;

public class Book extends Product {
private String genre;
private String authour;
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getAuthour() {
	return authour;
}
public void setAuthour(String authour) {
	this.authour = authour;
}

public void display() {
	System.out.println("--BOOK--");
	super.display();
	System.out.println("Genre : "+genre);
	System.out.println("Authour : "+authour);
}
}
