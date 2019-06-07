package com.samtech.exception;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException() {
		super();
	}
	
	public ProductNotFoundException(String message , Throwable cause, boolean enableSuppression, boolean writeableStackTrace) {
		super(message,cause,enableSuppression,writeableStackTrace);
		
	}
	
	public ProductNotFoundException(String message) {
		super(message);
	}
	
	public ProductNotFoundException(String message ,Throwable cause) {
		super(message,cause);
	}
	
	

}
