package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.model.Product;

public class ProductService {

	ProductDao pd = new ProductDaoImpl();

	public void createProduct(int vendorId, String name, double price, String description, int stockQuantity) throws SQLException {
		// TODO Auto-generated method stub
		pd.createProduct(vendorId,name,price,description,stockQuantity);
		
	}

	


	public List<Product> displayProductDetails() throws SQLException {
		// TODO Auto-generated method stub
		return pd.displayProductDetails();
	}

}