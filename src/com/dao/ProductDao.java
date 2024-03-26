package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Product;

public interface ProductDao {

	

	void createProduct(int vendorId, String name, double price, String description, int stockQuantity)throws SQLException ;

	List<Product> displayProductDetails()throws SQLException;


	List<Product> displaysortProductDetails()throws SQLException;

	List<Product> displaydescsortProductDetails()throws SQLException;

	void editProductDetails(String name1, double price1, String description1, int stockQuantity1, int vendorId1, int productId1)throws SQLException;

	void deleteProduct(int productId)throws SQLException;


	void buyProductDetails(int productId)throws SQLException;

}