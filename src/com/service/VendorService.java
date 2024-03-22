package com.service;

import java.sql.SQLException;
import java.util.List;

import com.controller.*;
import com.dao.*;
import com.dao.CustomerDaoImpl;
import com.model.Vendor;

public class VendorService {
	VendorDaoImpl vendorDao=new VendorDaoImpl();

	public void insertvendor(String name, String email, String password, String address) throws SQLException {
		vendorDao.insertvendor(name,email,password,address);
	}

	public void insertproduct(int vid, String pname, double price, String description, int stock_quantity)throws SQLException {
		
		vendorDao.insertproduct(vid,pname,price,description,stock_quantity);
		
	}

	public void updateproduct(int vid, String pname, double price, String description, int stock_quantity)throws SQLException {
		vendorDao.updateproduct(vid,pname,price,description,stock_quantity);
	}

	public Vendor displayproducts(int vid) throws SQLException {
		return vendorDao.displayproducts(vid);
		
	}

	public List<Vendor> displayallvendor() throws SQLException{
		
		return vendorDao.displayallvendor();
	}

	public Vendor searchvendor(String name) throws SQLException{
		return vendorDao.searchvendor(name);
	}

}
