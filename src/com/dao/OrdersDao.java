package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.exception.InvalidIdException;
import com.model.Customer;
import com.model.Orders;
import com.model.Product;

public interface OrdersDao {
	public List<Orders> getOrderDetailsOfCustomer(int cid)throws SQLException;
	
	public List<Orders> getOrderDetailsByPID(int pid) throws SQLException;
	
	public void insertOrder(int customerId, int productId, double totalPrice, String address, int numOfItems,
			LocalDate now) throws SQLException;
	
	public void updateAvailableProduct(int productId, int i) throws SQLException;

	public Customer validateCustomer(int customerId) throws InvalidIdException, SQLException;

	public List<Product> fetchAllProducts();

	public List<Orders> getOrderInRange(LocalDate startDate, LocalDate endDate) throws SQLException;
	
	
}
