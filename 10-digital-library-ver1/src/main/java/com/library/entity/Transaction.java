package com.library.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Transaction {
	@Id
	@GeneratedValue
private int transactionId;
	@JsonFormat(pattern = "dd-MM-yyyy")
private LocalDate borrowDate;
	@JsonFormat(pattern = "dd-MM-yyyy")
private LocalDate returnedDate;
private String status;
@ManyToOne
@JoinColumn(name="uid") //optional
private User user; //many to one
@ManyToOne
@JoinColumn(name="bookid") //optional
private Book book; // many to one
@OneToOne
@JoinColumn(name="penalyid") //optional
private Penalty penalty; //one to one
public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public LocalDate getBorrowDate() {
	return borrowDate;
}
public void setBorrowDate(LocalDate borrowDate) {
	this.borrowDate = borrowDate;
}
public LocalDate getReturnedDate() {
	return returnedDate;
}
public void setReturnedDate(LocalDate returnedDate) {
	this.returnedDate = returnedDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public Penalty getPenalty() {
	return penalty;
}
public void setPenalty(Penalty penalty) {
	this.penalty = penalty;
}


}
