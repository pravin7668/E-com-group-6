package com.service;

import java.util.List;

import com.dao.CartDaoImpl;
import com.model.Cart;

public class CartService {
	CartDaoImpl cd = new CartDaoImpl();

	public void addProduct(int id, int customerId, int productId, int quantity) throws Exception{
		// TODO Auto-generated method stub
		cd.addProduct(id,customerId,productId,quantity);
		
	}

	


	public List<Cart> displayCartDetails() throws Exception{
		// TODO Auto-generated method stub
		return cd.displayCartDetails();
	}

}

