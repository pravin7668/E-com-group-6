package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void insertCustomer(String name, String email, String password) throws SQLException {
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
	public void deleteCustomer(int cid) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="delete from customer where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, cid);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

}
