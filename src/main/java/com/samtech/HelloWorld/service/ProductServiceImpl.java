package com.samtech.HelloWorld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.samtech.HelloWorld.bo.Product;
import com.samtech.HelloWorld.dao.ProductDao;
@Service
@Qualifier("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	
	@Override
	public List getProducts() {
		return productDao.getProducts();
	}
	
	public Product getProduct(int id) {
		return productDao.getProductById(id);
	}
	
	@Override
	public Product upadateProduct(Product p) {
		return productDao.updateProduct(p);
	}

	@Override
	public int saveProduct(Product p) {
		return productDao.insertProduct(p);
	}

	@Override
	public int deleteProduct(int id) {
		return productDao.dropProduct(id);
	}
	
}
