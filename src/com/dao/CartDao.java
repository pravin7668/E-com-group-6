package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Cart;


public interface CartDao {
	public void addProduct(int id, int customerId, int productId, int quantity) throws SQLException, Exception;
	public List<Cart> displayCartDetails() throws Exception;  

}
