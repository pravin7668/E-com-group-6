package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.CustomerNotFoundException;
import com.model.Customer;
import com.util.DBUtil;

public class AuthenticationDaoImpl implements AuthenticationDao{

	@Override
	public void addCustomer(String name, String email, String password) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="insert into customer(name,email,password) values(?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, password);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

	@Override
	public Customer validateEmail(String cEmail) throws SQLException, CustomerNotFoundException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from customer where email=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, cEmail);
		ResultSet rst=pstmt.executeQuery();
		if (rst.next()) {
			int id=rst.getInt("id");
			String mail=rst.getString("email");
			String name=rst.getString("name");
			String password=rst.getString("password");
			Customer c=new Customer(id,name,mail,password);
			return c;
		}
		DBUtil.dbClose();
		throw new CustomerNotFoundException("Customer Not Found");
	}

	@Override
	public void updatePassword(String cEmail, String cPassword) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="update customer set password=? where email=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1,cPassword);
		pstmt.setString(2, cEmail);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

}
