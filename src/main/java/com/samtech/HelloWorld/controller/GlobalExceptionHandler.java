package com.samtech.HelloWorld.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.samtech.HelloWorld.dto.Error;
import com.samtech.exception.ProductNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public String productNotFoundException(ProductNotFoundException e ,Model model) {
		Error error = null;
		error = new Error();
		
		error.setErrorCode(101);
		error.setErrorDiscription("product not found");
		model.addAttribute(error);
		
		
		return "resource-not-found";
	}
	
	
	
	

}
