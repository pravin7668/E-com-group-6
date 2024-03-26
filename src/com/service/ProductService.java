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
	

	public List<Product> displaysortProductDetails(List<Product> list3, String order) throws SQLException {
		// TODO Auto-generated method stub
		return pd.displaysortProductDetails();
	}


	public List<Product> displaydescsortProductDetails(List<Product> list3, String order) throws SQLException{
		// TODO Auto-generated method stub
		return pd.displaydescsortProductDetails();
	}
	
	public void editProductDetails(String name1, double price1, String description1, int stockQuantity1,int vendorId1, int productId1)throws SQLException {
		// TODO Auto-generated method stub
		
		 pd.editProductDetails(name1,price1,description1,stockQuantity1,vendorId1,productId1);
	}

	public void deleteProduct(int productId)throws SQLException {
		// TODO Auto-generated method stub
		pd.deleteProduct(productId);
		
	}




	public void buyProductDetails(int productId) throws SQLException{
		// TODO Auto-generated method stub
		pd.buyProductDetails(productId);
		
	}
}