package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Vendor;

import com.util.DBUtil;

public class VendorDaoImpl implements VendorDao {
	@Override
	public void insertvendor(String name, String email, String password,String address) throws SQLException {
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
   public void insertproduct(int vid, String pname, double price, String description, int stock_quantity)throws SQLException {
	   Connection conn=DBUtil.getDBConn();
		String sql="insert into vendor(pname,price,description,stock_quantity) values(?,?,?,?) where vendor_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, pname);
		pstmt.setDouble(2, price);
		pstmt.setString(3, description);
		pstmt.setInt(4, stock_quantity);
		
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
		
	}
   @Override
   public void updateproduct(int vid, String pname, double price, String description, int stock_quantity)throws SQLException {
	   Connection conn=DBUtil.getDBConn();
		
		String sql="update product set name = ?,price =?,description=?,stock_quantity=? where id =?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, pname);
		pstmt.setDouble(2, price);
		pstmt.setString(3, description);
		pstmt.setInt(4, stock_quantity);
		pstmt.setInt(5, vid);
		pstmt.executeUpdate();
		DBUtil.dbClose();
	}
@Override
public Vendor displayproducts(int id) throws SQLException {
	List<Vendor> list = new ArrayList<Vendor>();
	Connection conn = DBUtil.getDBConn();

	String sql = "select * from product where id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, id);
	ResultSet rst = pstmt.executeQuery();

	if (rst.next()) {
		id = rst.getInt("id");
		String name = rst.getString("name");
		double price= rst.getDouble("price");
		String description=rst.getString("description");
		int stock_quantity=rst.getInt("stock_quantity");
		Vendor v = new Vendor(id, name, price,description,stock_quantity);
		list.add(v);
		return v;
	}
	DBUtil.dbClose();
	throw new NullPointerException("Invalid ID");
	
}
@Override
public List<Vendor> displayallvendor() throws SQLException {
	Connection conn = DBUtil.getDBConn();
	List<Vendor> list = new ArrayList<Vendor>();
	String sql = "select * from vendor";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rst = pstmt.executeQuery();
	while (rst.next()) {
		int id=rst.getInt("id");
		String name = rst.getString("name");
		String email = rst.getString("email");
		String password = rst.getString("password");
		String address=rst.getString("address");
		
		Vendor v=new Vendor();
		v.setId(id);
		v.setName(name);
		v.setEmail(email);
		v.setPassword(password);
		v.setAddress(address);
		list.add(v);
	}
	DBUtil.dbClose();
	return list;
}
@Override
public Vendor searchvendor(String name) throws SQLException {
	List<Vendor> list = new ArrayList<Vendor>();
	Connection conn = DBUtil.getDBConn();

	String sql = "select * from vendor where name=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	ResultSet rst = pstmt.executeQuery();

	if (rst.next()) {
		int id=rst.getInt("id");
		String name1 = rst.getString("name");
		String email = rst.getString("email");
		String password = rst.getString("password");
		String address=rst.getString("address");
		Vendor v = new Vendor(id, name1, email,password,address);
		list.add(v);
		return v;
	}
	DBUtil.dbClose();
	throw new NullPointerException("Invalid name");
	
}
}
