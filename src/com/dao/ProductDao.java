package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Product;

public interface ProductDao {

	

	void createProduct(int vendorId, String name, double price, String description, int stockQuantity)throws SQLException ;

	List<Product> displayProductDetails()throws SQLException;


	List<Product> displaysortProductDetails()throws SQLException;

	List<Product> displaydescsortProductDetails()throws SQLException;


}