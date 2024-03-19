package com.dao;

import java.sql.SQLException;

public interface CustomerDao {

	public void insertCustomer(String name, String email, String password) throws SQLException;

	public void deleteCustomer(int cid) throws SQLException;

}
