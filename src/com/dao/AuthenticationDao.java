package com.dao;

import java.sql.SQLException;

import com.exception.CustomerNotFoundException;
import com.model.Customer;

public interface AuthenticationDao {

	void addCustomer(String name, String email, String password) throws SQLException;

	Customer validateEmail(String cEmail) throws SQLException,CustomerNotFoundException;

	void updatePassword(String cEmail, String cPassword) throws SQLException;

}
