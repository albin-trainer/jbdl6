package com.library.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.library.dto.ApiError;
import com.library.exception.AuthourNotFoundException;
@RestControllerAdvice//for global exception handler for REST APIs
public class GlobalExceptionHandler {
	@ExceptionHandler(exception = AuthourNotFoundException.class)
	public  ResponseEntity<ApiError> handleException(Exception e) {
		ApiError apierror=new ApiError(e.getMessage(),404);
	
		return  new ResponseEntity<ApiError>(apierror,HttpStatus.NOT_FOUND);
	}
}
