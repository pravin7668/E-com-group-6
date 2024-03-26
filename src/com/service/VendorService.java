package com.service;

import java.sql.SQLException;
import java.util.List;

import com.controller.*;
import com.dao.*;
import com.dao.CustomerDaoImpl;
import com.exception.VendorNotFoundException;
import com.model.Vendor;

public class VendorService {
	VendorDaoImpl vendorDao=new VendorDaoImpl();

	public void insertVendor(String name, String email, String password, String address) throws SQLException {
		vendorDao.insertVendor(name,email,password,address);
	}

	public void insertProduct(int vid, String pname, double price, String description, int stock_quantity)throws SQLException {
		
		vendorDao.insertProduct(vid,pname,price,description,stock_quantity);
		
	}

	public void updateProduct(int vid, String pname, double price, String description, int stock_quantity)throws SQLException {
		vendorDao.updateProduct(vid,pname,price,description,stock_quantity);
	}

	public Vendor displayProducts(int vid) throws SQLException {
		return vendorDao.displayProducts(vid);
		
	}

	public List<Vendor> displayAllVendor() throws SQLException{
		
		return vendorDao.displayAllVendor();
	}

	public Vendor searchVendor(String name) throws SQLException,VendorNotFoundException {
		return vendorDao.searchVendor(name);
	}

}
