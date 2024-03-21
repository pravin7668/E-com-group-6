package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

}
