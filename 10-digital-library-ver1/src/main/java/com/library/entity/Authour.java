package com.library.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Authour {
@Id	
private int authourId;
private String name;
@OneToMany(mappedBy = "authour")//inverse side
private List<Book> books; //one to many
public Authour(int authourId, String name) {
	super();
	this.authourId = authourId;
	this.name = name;
}
public Authour(){
	
}
public int getAuthourId() {
	return authourId;
}
public void setAuthourId(int authourId) {
	this.authourId = authourId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Book> getBooks() {
	return books;
}
public void setBooks(List<Book> books) {
	this.books = books;
}

}
