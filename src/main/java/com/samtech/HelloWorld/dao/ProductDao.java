package com.samtech.HelloWorld.dao;

import java.util.List;

import com.samtech.HelloWorld.bo.Product;

public interface ProductDao{
	List<Product> getProducts();
	Product getProductById(int id);
	Product updateProduct(Product p);
	int insertProduct(Product p);
	int dropProduct(int i);
}
