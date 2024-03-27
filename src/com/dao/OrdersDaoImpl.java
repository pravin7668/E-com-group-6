package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.exception.InvalidIdException;
import com.model.Customer;
import com.model.Orders;
import com.util.DBUtil;


public class OrdersDaoImpl implements OrdersDao{
	
	public List<Orders> getOrderDetailsOfCustomer(int cid) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		List<Orders> list = new ArrayList<>();
		String sql = "select * from orders where customer_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, cid);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) { 
			int Id= rst.getInt("id");
			int customerId = rst.getInt("customer_id");
			int productId = rst.getInt("product_id");
			Double price = rst.getDouble("total_price");
			String address = rst.getString("shipping_address");
			int quantity = rst.getInt("quantity");
	        
			Orders od = new Orders();
			od.setId(Id);
			od.setCustomerId(customerId);
			od.setProductId(productId);
			od.setTotalPrice(price);
			od.setShippingAddress(address);
			od.setQuantity(quantity);
			list.add(od);
		}
		DBUtil.dbClose();
		return list;
	}
// CASE 2:	
	public Customer validateCustomer(int customerId) throws InvalidIdException, SQLException {
		Connection conn=DBUtil.getDBConn();
		Customer c=new Customer();
		String sql="select * from customer where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()) {
			int id=rst.getInt("id");
			c.setId(id);
			return c;
		}

		DBUtil.dbClose();

		throw new InvalidIdException("Invalid customer Id");

		
	}

	public void insertOrder(int customerId, int productId, double totalPrice, String address, int numOfItems, LocalDate now) throws SQLException {
			Connection conn=DBUtil.getDBConn();
	

	        String sql = "insert into orders(customer_id,product_id,total_price,shipping_address,quantity,order_date) values(?,?,?,?,?,?)";
	        try {
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, customerId);
	            pstmt.setInt(2, productId);
	            pstmt.setDouble(3, totalPrice);
	            pstmt.setString(4, address);
	            pstmt.setInt(5, numOfItems);
	            Date sqlDate = Date.valueOf(now);
	            pstmt.setDate(6, sqlDate); 
	            pstmt.executeUpdate();

			DBUtil.dbClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void updateAvailableProduct(int productId, int i) throws SQLException {
		try {
			Connection conn=DBUtil.getDBConn();
			String sql="update product set stock_quantity=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,i);
			pstmt.setInt(2, productId);
			pstmt.executeUpdate();
			
			DBUtil.dbClose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Orders> getOrderDetailsByPID(int pid) throws SQLException {
		
		Connection conn=DBUtil.getDBConn();
		String sql="Select id,customer_id,total_price,quantity from orders where product_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, pid);
		List<Orders> orderList = new ArrayList<>();
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) { 
			int Id= rst.getInt("id");
			int customerId = rst.getInt("customer_id");
			Double price = rst.getDouble("total_price");
			int quantity = rst.getInt("quantity");
			
			Orders od = new Orders();
			od.setId(Id);
			od.setCustomerId(customerId);
			od.setTotalPrice(price);
			od.setQuantity(quantity);
			orderList.add(od);
			
	}
		DBUtil.dbClose();
		return orderList;
		}
	
	public List<Orders> getOrderInRange(int i,LocalDate startDate, LocalDate endDate) throws SQLException {
		  Connection conn = DBUtil.getDBConn();
		  try {
		    String sql = "SELECT * FROM orders WHERE order_date BETWEEN ? AND ? having customer_id=?";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setDate(1,java.sql.Date.valueOf(startDate) );
		    pstmt.setDate(2,java.sql.Date.valueOf(endDate));
		    pstmt.setInt(3,i);

		    ResultSet rs = pstmt.executeQuery();
		    List<Orders> ordersList = new ArrayList<>();

		    while (rs.next()) {
		      Orders order = new Orders();
		      order.setId(rs.getInt("id"));  
		      ordersList.add(order);
		    }

		    return ordersList;
		  } finally {
		    DBUtil.dbClose();
		  }
		}
	
	public void updateAddress(int i, String address) throws SQLException {
		try {
			Connection conn=DBUtil.getDBConn();
			String sql="Update orders set shipping_address=? where customer_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setInt(2, i);
			pstmt.executeUpdate();
			
			DBUtil.dbClose();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	

	
	}
	
	

	





