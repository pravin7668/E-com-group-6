package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exception.InvalidIdException;
import com.model.Customer;
import com.model.Orders;
import com.model.Product;
import com.util.DBUtil;


public class OrdersDaoImpl implements OrdersDao{
	
	public List<Orders> getOrderDetailsOfCustomer(int cid) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="Select id,product_id,total_price,quantity from customer where customer_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, cid);
		ResultSet rs=pstmt.executeQuery();
		List<Orders> orderList=new ArrayList<>();
		
		while(rs.next()) {
			Orders order =new Orders();
			order.setId(rs.getInt(cid));
			orderList.add(order);
		}
		DBUtil.dbClose();
		return orderList;
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
	public List<Product> fetchAllProducts(){
		return null;
	
	}

	public void insertOrder(int customerId, int productId, double totalPrice, String address, int numOfItems,
			LocalDate now) throws SQLException {
		Connection conn=DBUtil.getDBConn();

		String sql="insert into booking values(?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,customerId);
		pstmt.setInt(2,productId);
		pstmt.setDouble(3,totalPrice);
		pstmt.setString(4,address);
		pstmt.setInt(5,numOfItems);
		pstmt.setString(6, now.toString());
		pstmt.executeUpdate();
	
		DBUtil.dbClose();
		
	}

	public void updateAvailableProduct(int productId, int i) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="update product set stock_quantity=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,i);
		pstmt.setInt(2, productId);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
		
	}
	
	public List<Orders> getOrderDetailsByPID(int pid) throws SQLException {
		
		Connection conn=DBUtil.getDBConn();
		String sql="Select id,customer_id,total_price,quantity from  where product_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, pid);
		ResultSet rs=pstmt.executeQuery();
		List<Orders> orderList=new ArrayList<>();
		
		while(rs.next()) {
			Orders order =new Orders();
			order.setId(rs.getInt(pid));
			orderList.add(order);
		}
		DBUtil.dbClose();
		return orderList;
	}
	
	public List<Orders> getOrderInRange(LocalDate startDate, LocalDate endDate) throws SQLException {
		  Connection conn = DBUtil.getDBConn();
		  try {
		    String sql = "SELECT * FROM orders WHERE order_date BETWEEN ? AND ?";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setDate(1,java.sql.Date.valueOf(startDate) );
		    pstmt.setDate(2,java.sql.Date.valueOf(endDate));

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
	

	
	}
	
	

	





