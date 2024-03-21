package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;

public interface CustomerDao {

	public List<Customer> getAllCustomer() throws SQLException;

	public void updateName(int cid1, String name) throws SQLException;

	public void updateEmail(int cid1, String email) throws SQLException;

	public void updatePassword(int cid1, String password) throws SQLException;

}
