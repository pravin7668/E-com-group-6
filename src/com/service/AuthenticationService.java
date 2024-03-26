package com.service;

import java.sql.SQLException;


import com.dao.AuthenticationDao;
import com.dao.AuthenticationDaoImpl;
import com.exception.CustomerNotFoundException;
import com.exception.VendorNotFoundException;
import com.model.Customer;
import com.model.User;
import com.model.Vendor;

public class AuthenticationService {
	AuthenticationDao authenticationDao=new AuthenticationDaoImpl();
	public boolean checkConfirmPassword(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {
			return true;
		}
		return false;
	}

	public void addCustomer(String name, String email, String password) throws SQLException {
		authenticationDao.addCustomer(name,email,password);
	}

	public User validateEmail(String cEmail) throws SQLException, CustomerNotFoundException {
		return authenticationDao.validateEmail(cEmail);
	}

	public boolean validatePassword(User user, String cPassword) {
		if(user.getPassword().equals(cPassword)) {
			return true;
		}
		return false;
	}

	public void updatePassword(String cEmail, String cPassword) throws SQLException {
		authenticationDao.updatePassword(cEmail,cPassword);
		
	}

	public void addUser(String email, String password, String role) throws SQLException {
		authenticationDao.addUser(email,password,role);
	}

	public Customer getCustomerId(String cEmail) throws SQLException, CustomerNotFoundException{
		
		return authenticationDao.getCustomerId(cEmail);
	}

	public void updateUserPassword(String cEmail, String userPassword) throws SQLException{
		authenticationDao.updateUserPassword(cEmail, userPassword);
	}

	public void addVendor(String name, String email, String password,String address)throws SQLException{
		authenticationDao.addVendor(name,email,password,address);
	}

	public Vendor getVendorId(String cEmail) throws SQLException, VendorNotFoundException {
		// TODO Auto-generated method stub
		return authenticationDao.getVendorId(cEmail);
	}

}
