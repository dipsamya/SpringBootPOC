package com.samtech.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class ProductClient {
	@Autowired
	RestTemplate restTemplate;
	
	public static void main(String[] args) {
		ProductClient client =new ProductClient();
		client.getAllProduct();
	}
	
	public void getAllProduct() {
		HttpEntity<String> entity=new HttpEntity<String>("");
		System.out.println(restTemplate.exchange("http://localhost:8080/get-products", HttpMethod.GET, entity,String.class));
	}  
}
