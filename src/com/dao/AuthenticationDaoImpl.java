package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.CustomerNotFoundException;
import com.exception.VendorNotFoundException;
import com.model.Customer;
import com.model.User;
import com.model.Vendor;
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
	public User validateEmail(String cEmail) throws SQLException, CustomerNotFoundException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from user where email=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, cEmail);
		ResultSet rst=pstmt.executeQuery();
		if (rst.next()) {
			int id=rst.getInt("id");
			String mail=rst.getString("email");
			String password=rst.getString("password");
			String role=rst.getString("role");

			User u=new User(id,mail,password,role);
			return u;
		}
		DBUtil.dbClose();
		throw new CustomerNotFoundException("User Not Found");
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

	@Override
	public void addUser(String email, String password, String role) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="insert into user(email,password,role) values(?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		pstmt.setString(3, role);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
		
		
	}

	@Override
	public Customer getCustomerId(String cEmail) throws SQLException, CustomerNotFoundException {

		Connection conn=DBUtil.getDBConn();
		String sql="select * from customer where email=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, cEmail);
		ResultSet rst=pstmt.executeQuery();
		if (rst.next()) {
			int id=rst.getInt("id");
			String name=rst.getString("name");
			String mail=rst.getString("email");
			String password=rst.getString("password");
			

			Customer c=new Customer(id,name,mail,password);
			return c;
		}
		throw new CustomerNotFoundException("Customer Not Found");

		
	}

	@Override
	public void updateUserPassword(String cEmail, String userPassword) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="update user set password=? where email=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1,userPassword);
		pstmt.setString(2, cEmail);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

	@Override
	public void addVendor(String name, String email, String password,String address) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="insert into vendor(name,email,password,address) values(?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, password);
		pstmt.setString(4, address);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
		
	}

	@Override
	public Vendor getVendorId(String cEmail) throws SQLException, VendorNotFoundException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from vendor where email=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, cEmail);
		ResultSet rst=pstmt.executeQuery();
		if (rst.next()) {
			int id=rst.getInt("id");
			String name=rst.getString("name");
			String mail=rst.getString("email");
			String password=rst.getString("password");
			String address=rst.getString("address");

			Vendor c=new Vendor(id,name,mail,password,address);
			return c;
		}
		throw new VendorNotFoundException("Vendor Not Found");
	}

}
