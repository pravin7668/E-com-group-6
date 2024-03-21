package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Customer;

public class CustomerService {
	CustomerDao customerDao = new CustomerDaoImpl();

	public List<Customer> getAllCustomer() throws SQLException {
		return customerDao.getAllCustomer();
	}

	public void updateName(int cid1, String name) throws SQLException {
		customerDao.updateName(cid1, name);
	}

	public void updateEmail(int cid1, String email) throws SQLException {
		customerDao.updateEmail(cid1, email);
	}

	public void updatePassword(int cid1, String password) throws SQLException {
		customerDao.updatePassword(cid1, password);
	}

}
