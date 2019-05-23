package com.samtech.HelloWorld.service;

import java.util.List;

import com.samtech.HelloWorld.bo.Product;

public interface ProductService {
	List getProducts();
	Product getProduct(int id);
	Product upadateProduct(Product p);
	int saveProduct(Product p);
	int deleteProduct(int id);
}
