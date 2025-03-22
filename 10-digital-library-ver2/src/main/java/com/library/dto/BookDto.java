package com.library.dto;

import com.library.entity.Genre;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class BookDto {

private int bookId;
private String bookName;
@Enumerated(EnumType.STRING)
private Genre genre;
private float cost;
private int stock;
private int authourId;
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public Genre getGenre() {
	return genre;
}
public void setGenre(Genre genre) {
	this.genre = genre;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getAuthourId() {
	return authourId;
}
public void setAuthourId(int authourId) {
	this.authourId = authourId;
}

}
