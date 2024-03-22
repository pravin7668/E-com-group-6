package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;
import com.model.Orders;
import com.model.Product;
import com.dao.OrdersDao;
import com.dao.OrdersDaoImpl;
import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.exception.InvalidIdException;

public class OrdersService {
	OrdersDao ordersdao=new OrdersDaoImpl();
	ProductDao pd = new ProductDaoImpl();
	public List<Orders> getOrderDetailsOfCustomer(int cid) throws SQLException {
		List<Orders> list=new ArrayList<Orders>();
		list=ordersdao.getOrderDetailsOfCustomer(cid);
		return list;
	}
	
	public Customer validateCustomer(int customerId)throws SQLException, InvalidIdException {
			return ordersdao.validateCustomer(customerId);
		
		}


	public List<Product> fetchAllProducts() throws SQLException {
		
		return pd.displayProductDetails();
	}

	public boolean checkIfProductAvailable(List<Product> list2, int numOfItems, int productId) {
		for (Product e:list2) {
			if(e.getId()==productId) {
				if(e.getStockQuantity()>=numOfItems) {
					return true;
				}
			}
		}
		return false;
	}

	public void updateAvailableProduct(List<Product> list2, int productId, int numOfItems) throws SQLException {
		for (Product e:list2) {
			if(e.getId()==productId) {
				ordersdao.updateAvailableProduct(productId,(e.getStockQuantity()-numOfItems));
			}
		}
		
	}

	public void insertOrder(int productId, int customerId, int numOfItems,String address, List<Product> list2) throws SQLException {
		double totalPrice=0;
		for (Product e:list2) {
			if(e.getId()==productId) {
				totalPrice=(e.getPrice()*numOfItems);
				break;
			}
		}
		ordersdao.insertOrder(customerId,productId,totalPrice,address,numOfItems,LocalDate.now());
		
	}
	
	public List<Orders> getOrderDetailsByPID(int pid) throws SQLException {
		List<Orders> list1=new ArrayList<Orders>();
		list1=ordersdao.getOrderDetailsByPID(pid);
		return list1;
	}

	public List<Orders> getOrderInRange(LocalDate startDate, LocalDate endDate) throws SQLException {
		List<Orders> list3=new ArrayList<Orders>();
		list3 = ordersdao.getOrderInRange(startDate,endDate);
		return list3;
	}




	
	

	

}
