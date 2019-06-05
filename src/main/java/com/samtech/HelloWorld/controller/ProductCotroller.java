package com.samtech.HelloWorld.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samtech.HelloWorld.bo.Product;
import com.samtech.HelloWorld.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductCotroller {
	@Autowired
	@Qualifier("productService")
	ProductService productService;
	
	@RequestMapping(value= "/get-products", method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public List<Product> getProducts() {
		System.err.println("request is coming for geting all the product");
		return productService.getProducts();
	}
	
	@RequestMapping(value= "/{id}", method=RequestMethod.GET, produces= {MediaType.APPLICATION_PROBLEM_JSON_VALUE})
	public Product getProduct(@PathVariable("id") int id) {
		System.err.println("request is coming for geting the product- id -->"+id);
		return productService.getProduct(id);
	}
	
	@PutMapping(path="/update", produces= {MediaType.APPLICATION_JSON_VALUE} , consumes= {MediaType.APPLICATION_JSON_VALUE})
	public Product updateProduct(@RequestBody Product p) {
		return productService.upadateProduct(p);
	}
	
	@PostMapping(path="/save", produces= {MediaType.APPLICATION_JSON_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public String saveProduct(@RequestBody Product p) {
		return productService.saveProduct(p) + " row inserted" ;
	}
	@DeleteMapping(path="/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		return productService.deleteProduct(id) + " row deleted";
	}
}

