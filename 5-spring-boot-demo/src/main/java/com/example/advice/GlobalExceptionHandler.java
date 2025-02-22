package com.example.advice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dto.ApiError;
import com.example.exception.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception = {ProductNotFoundException.class,Exception.class})
	public ResponseEntity<?> handleProductNotFound(ProductNotFoundException e) {
		System.out.println("Exception handled");
		ApiError error=new ApiError();
		error.setError(e.getMessage());
		error.setStatus("404");
		error.setDate(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e){
		System.out.println("validation Exception handled");
		Map<String, String> map=new HashMap<>();
		e.getFieldErrors().forEach(m-> map.put(m.getField(), m.getDefaultMessage()));
		return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
				}
}
