package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Cart;
import com.util.DBUtil;

public class CartDaoImpl implements CartDao{

	public void addProduct(int id, int customerId, int productId, int quantity) throws Exception {
		try {
			Connection conn=DBUtil.getDBConn();
			String sql = "insert into cart(id,customer_id,product_id,quantity) values(?,?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setInt(2,customerId);
			pstmt.setInt(3,productId);
			pstmt.setInt(4,quantity);
			
			pstmt.executeUpdate();
			
			DBUtil.dbClose();
			}
			catch(SQLException e) { e.printStackTrace();}
		}


			
			
		public List<Cart> displayCartDetails() throws Exception{
			List<Cart> list = null;
			try {
				Connection conn=DBUtil.getDBConn();
				list = new ArrayList<>();
				String sql = "select * from cart";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
				while (rst.next()) { 
					int id= rst.getInt("id");
					int customerId  = rst.getInt("customerId");
					int productId = rst.getInt("productId");
					int quantity = rst.getInt("quantity");
					
					
					
					
					Cart cd = new Cart(id, customerId, productId, quantity);
					list.add(cd);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
					DBUtil.dbClose();
					
					return list;
				}
	}
	
