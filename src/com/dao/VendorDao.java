package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Vendor;

public interface VendorDao {

	public void insertvendor(String name, String email, String password, String address) throws SQLException;
		
		
	

	public void insertproduct(int vid, String pname, double price, String description, int stock_quantity)throws SQLException;
		
		
	
	public void updateproduct(int vid, String pname, double price, String description, int stock_quantity)throws SQLException;
		
	

	public Vendor displayproducts(int vid)throws SQLException;
	
	public List<Vendor> displayallvendor() throws SQLException;




	public Vendor searchvendor(String name) throws SQLException;
		
		
	
}
