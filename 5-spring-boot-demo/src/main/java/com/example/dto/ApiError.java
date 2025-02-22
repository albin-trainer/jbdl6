package com.example.dto;

import java.time.LocalDate;

public class ApiError {
private String error;
private LocalDate date;
private String status;
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}



}
