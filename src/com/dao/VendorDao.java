package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Vendor;

public interface VendorDao {

	public void insertVendor(String name, String email, String password, String address) throws SQLException;
		
		
	

	public void insertProduct(int vid, String pname, double price, String description, int stock_quantity)throws SQLException;
		
		
	
	public void updateProduct(int vid, String pname, double price, String description, int stock_quantity)throws SQLException;
		
	

	public Vendor displayProducts(int vid)throws SQLException;
	
	public List<Vendor> displayAllVendor() throws SQLException;




	public Vendor searchVendor(String name) throws SQLException;
		
		
	
}
