package com.samtech.HelloWorld.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.samtech.HelloWorld.bo.Product;
@Repository
public class ProductDaoImpl implements ProductDao{
	private final String ALL_PRODUCT="select * from product1";
	private final String PRODUCT_BY_ID="select * from product1 where id = ?";
	private final String UPDATE_PRODUCT="update Product1 set name = ? where id = ?";
	private final String INSERT_PRODUCT="insert into Product1(id, name) values(?, ?)";
	private final String DELETE_PRODUCT="delete From Product1 where id = ?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List getProducts() {
		List<Product> pList=new ArrayList<>();
		pList = jdbcTemplate.query(ALL_PRODUCT, new ProductRowMapperImpl());
		return pList;
	}
	
	
	
	@Override
	public Product getProductById(int id) {
		Product p = jdbcTemplate.queryForObject(PRODUCT_BY_ID, new ProductRowMapperImpl(), id);
		return p;
	}

	@Override
	public Product updateProduct(Product p) {
		int i=jdbcTemplate.update(UPDATE_PRODUCT, new Object[] {p.getProductName(), p.getProductId()});
		System.err.println(i+" is updated.");
		return p;
	}

	@Override
	public int insertProduct(Product p) {
		int i=jdbcTemplate.update(INSERT_PRODUCT, new Object[] {p.getProductId(),p.getProductName()});
		System.err.println("\n"+ i  + "row is inserted.");
		return i;
	}
	
	@Override
	public int dropProduct(int id) {
		int i = jdbcTemplate.update(DELETE_PRODUCT, id);
		return i;
	}


	public static final class ProductRowMapperImpl implements RowMapper<Product>{
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Product(rs.getInt("id"), rs.getString("name")); 
		}
		
	}
}
