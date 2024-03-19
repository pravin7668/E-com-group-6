package com.service;

import java.sql.SQLException;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;

public class CustomerService {
	CustomerDao customerDao=new CustomerDaoImpl();
	public void insertCustomer(String name, String email, String password) throws SQLException {
		customerDao.insertCustomer(name,email,password);
	}
	public void deleteCustomer(int cid) throws SQLException {
		customerDao.deleteCustomer(cid);
	}

}
