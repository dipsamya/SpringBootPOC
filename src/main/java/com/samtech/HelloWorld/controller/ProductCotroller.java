package com.samtech.HelloWorld.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;

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

import com.samtech.HelloWorld.Logging.HelloWorldLogging;
import com.samtech.HelloWorld.bo.Product;
import com.samtech.HelloWorld.service.ProductService;
import com.samtech.exception.ProductNotFoundException;

@RestController
@RequestMapping("/product")
public class ProductCotroller {
	private static final HelloWorldLogging logger = HelloWorldLogging.getLogger(ProductCotroller.class);
	@Autowired
	@Qualifier("productService")
	ProductService productService;
	
	@RequestMapping(value= "/get-products", method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public List<Product> getProducts() {
		logger.info("Request is Comming for getting all the product");
		return productService.getProducts();
	}
	
	@RequestMapping(value= "/{id}", method=RequestMethod.GET, produces= {MediaType.APPLICATION_PROBLEM_JSON_VALUE})
	public Product getProduct(@PathVariable("id") int id) {
		
		logger.debug("Request is comming for getting the product");
		if(id>=0) {
			throw new ProductNotFoundException("product not found");
		}
		return productService.getProduct(id);
	}
	
	@PutMapping(path="/update", produces= {MediaType.APPLICATION_JSON_VALUE} , consumes= {MediaType.APPLICATION_JSON_VALUE})
	public Product updateProduct(@RequestBody Product p) {
		logger.debug("Request is comming on inside upadate product");
		
		return productService.upadateProduct(p);
		
	}
	
	@PostMapping(path="/save", produces= {MediaType.APPLICATION_JSON_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public String saveProduct(@RequestBody Product p) {
		
		logger.debug("Request is comming Save product ");
		return productService.saveProduct(p) + " row inserted" ;
	}
	@DeleteMapping(path="/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		return productService.deleteProduct(id) + " row deleted";
	}
}

