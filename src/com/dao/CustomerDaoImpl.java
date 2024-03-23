package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.CustomerOrdersDto;
import com.exception.CustomerNotFoundException;
import com.model.Customer;

import com.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> getAllCustomer() throws SQLException {

		Connection conn = DBUtil.getDBConn();

		List<Customer> list = new ArrayList<>();

		String sql = "select * from customer";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			int id = rst.getInt("id");
			String customerName = rst.getString("name");
			String email = rst.getString("email");
			Customer c = new Customer();
			c.setId(id);
			c.setName(customerName);
			c.setEmail(email);
			list.add(c);
		}

		DBUtil.dbClose();

		return list;
	}

	@Override
	public void updateName(int cid1, String name) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "update customer set name=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, cid1);
		pstmt.executeUpdate();

		DBUtil.dbClose();

	}

	@Override
	public void updateEmail(int cid1, String email) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "update customer set email=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setInt(2, cid1);
		pstmt.executeUpdate();

		DBUtil.dbClose();

	}

	@Override
	public void updatePassword(int cid1, String password) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql = "update customer set password=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setInt(2, cid1);
		pstmt.executeUpdate();

		DBUtil.dbClose();

	}
	@Override
	public void deleteCustomer(int cid) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="delete from customer where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, cid);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}
	
	@Override
	public Customer searchCustomer(String name) throws SQLException, CustomerNotFoundException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from customer where name=? ";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		ResultSet rst =pstmt.executeQuery();
		if(rst.next()) {
			int id=rst.getInt("id");
			String cname=rst.getString("name");
			String email=rst.getString("email");
			Customer c=new Customer();
			c.setId(id);
			c.setName(cname);
			c.setEmail(email);
			return c;
		}

		DBUtil.dbClose();
		throw new CustomerNotFoundException("Customer Not Found Please Check The Name");
	}

	@Override
	public List<CustomerOrdersDto> getCustomerOrders(int id) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		List<CustomerOrdersDto> list=new ArrayList<CustomerOrdersDto>();
		String sql="select c.name as customer_name,p.name as product_name,o.total_price,o.quantity from customer c join orders o on c.id=o.customer_id join product p on p.id=o.product_id where o.customer_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst =pstmt.executeQuery();
		while (rst.next()) {
			String customerName=rst.getString("customer_name");
			String productName=rst.getString("product_name");
			double totalPrice=rst.getDouble("total_price");
			int quantity=rst.getInt("quantity");
			CustomerOrdersDto o=new CustomerOrdersDto();
			o.setCustomerName(customerName);
			o.setProductName(productName);
			o.setTotalPrice(totalPrice);
			o.setQuantity(quantity);
			list.add(o);
		}

		DBUtil.dbClose();
		return list;
	}

	@Override
	public void deleteOrders(int id) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="delete from orders where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

	@Override
	public void deleteCart(int id) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="delete from cart where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

	@Override
	public void deleteUser(String email) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="delete from user where email=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

}
