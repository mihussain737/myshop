package com.myshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
	
	private String message;
	public ProductNotFoundException(String message) {
		super(message);
	}
}
