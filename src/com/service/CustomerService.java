package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dto.CustomerOrdersDto;
import com.exception.CustomerNotFoundException;
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
	public Customer searchCustomer(String name) throws SQLException, CustomerNotFoundException {
		return customerDao.searchCustomer(name);
	}
	public void deleteCustomer(int cid) throws SQLException {
		customerDao.deleteCustomer(cid);
	}

	public List<CustomerOrdersDto> getCustomerOrders(int id) throws SQLException{
		return customerDao.getCustomerOrders(id);
	}

	public boolean validateToDelete(String forDelete) {
		if(forDelete.equals("CONFIRM")) {
			return true;
		}
		return false;
	}

	public void deleteOrders(int id) throws SQLException{
		customerDao.deleteOrders(id);
	}

	public void deleteCart(int id) throws SQLException{
		customerDao.deleteCart(id);
	}

	public void deleteUser(String email)  throws SQLException{
		customerDao.deleteUser(email);
		
	}

}
