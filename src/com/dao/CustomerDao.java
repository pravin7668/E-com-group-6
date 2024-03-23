package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.CustomerOrdersDto;
import com.exception.CustomerNotFoundException;
import com.model.Customer;

public interface CustomerDao {

	public List<Customer> getAllCustomer() throws SQLException;

	public void updateName(int cid1, String name) throws SQLException;

	public void updateEmail(int cid1, String email) throws SQLException;

	public void updatePassword(int cid1, String password) throws SQLException;

	public void deleteCustomer(int cid) throws SQLException;

	public Customer searchCustomer(String name) throws SQLException,CustomerNotFoundException;

	public List<CustomerOrdersDto> getCustomerOrders(int id) throws SQLException;

	public void deleteOrders(int id) throws SQLException;

	public void deleteCart(int id) throws SQLException;

	public void deleteUser(String email) throws SQLException;

}
