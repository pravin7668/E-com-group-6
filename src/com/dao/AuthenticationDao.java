package com.dao;

import java.sql.SQLException;

import com.exception.CustomerNotFoundException;
import com.exception.VendorNotFoundException;
import com.model.Customer;
import com.model.User;
import com.model.Vendor;


public interface AuthenticationDao {

	void addCustomer(String name, String email, String password) throws SQLException;

	User validateEmail(String cEmail) throws SQLException,CustomerNotFoundException;

	void updatePassword(String cEmail, String cPassword) throws SQLException;

	void addUser(String email, String password, String role) throws SQLException;

	Customer getCustomerId(String cEmail) throws SQLException,CustomerNotFoundException;

	void updateUserPassword(String cEmail, String userPassword) throws SQLException;

	void addVendor(String name, String email, String password,String address)throws SQLException;

	Vendor getVendorId(String cEmail) throws SQLException, VendorNotFoundException;

}
