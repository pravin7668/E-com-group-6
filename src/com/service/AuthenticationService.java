package com.service;

import java.sql.SQLException;

import com.dao.AuthenticationDao;
import com.dao.AuthenticationDaoImpl;
import com.exception.CustomerNotFoundException;
import com.model.Customer;

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

	public Customer validateEmail(String cEmail) throws SQLException, CustomerNotFoundException {
		return authenticationDao.validateEmail(cEmail);
	}

	public boolean validatePassword(Customer c, String cPassword) {
		if(c.getPassword().equals(cPassword)) {
			return true;
		}
		return false;
	}

	public void updatePassword(String cEmail, String cPassword) throws SQLException {
		authenticationDao.updatePassword(cEmail,cPassword);
		
	}

}
