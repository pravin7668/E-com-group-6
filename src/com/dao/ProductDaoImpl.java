package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;
import com.util.DBUtil;

public class ProductDaoImpl implements ProductDao{



	@Override
	public void createProduct(int vendorId, String name, double price, String description, int stockQuantity) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getDBConn();
		String sql = "insert into product(name,price,description,stock_quantity,vendor_id) values(?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setDouble(2,price);
		pstmt.setString(3,description);
		pstmt.setInt(4,stockQuantity);
		pstmt.setInt(5, vendorId);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}


	@Override
	public List<Product> displayProductDetails() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getDBConn();
		List<Product> list = new ArrayList<>();
		String sql = "select * from product";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) { 
			int productId= rst.getInt("id");
			String name = rst.getString("name");
			Double price = rst.getDouble("price");
			String description = rst.getString("description");
			int stockQuantity = rst.getInt("stock_quantity");
			int vendorId = rst.getInt("vendor_id");
			/*save it in an object*/
			
			Product pd = new Product(productId,name,price,description,stockQuantity,vendorId);
			list.add(pd);
		}
		DBUtil.dbClose();
		return list;
	}
		
		@Override
		public List<Product> displaysortProductDetails() throws SQLException {
			Connection conn=DBUtil.getDBConn();
			List<Product> list3 = new ArrayList<>();
			String sql = "select * from product order by price ASC";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) { //if id is present in the DB, I vl give customer obj else will throw InvalidIdException
				int productId= rst.getInt("id");
				String name = rst.getString("name");
				Double price = rst.getDouble("price");
				String description = rst.getString("description");
				int stockQuantity = rst.getInt("stock_quantity");
				int vendorId = rst.getInt("vendor_id");
				/*save it in an object*/
				
				Product pd = new Product(productId,name,price,description,stockQuantity,vendorId);
				list3.add(pd);
			}
			DBUtil.dbClose();
			return list3;
		}

		@Override
		public List<Product> displaydescsortProductDetails() throws SQLException {
			// TODO Auto-generated method stub
			Connection conn=DBUtil.getDBConn();
			List<Product> list3 = new ArrayList<>();
			String sql = "select * from product order by price DESC";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) { //if id is present in the DB, I vl give customer obj else will throw InvalidIdException
				int productId= rst.getInt("id");
				String name = rst.getString("name");
				Double price = rst.getDouble("price");
				String description = rst.getString("description");
				int stockQuantity = rst.getInt("stock_quantity");
				int vendorId = rst.getInt("vendor_id");
				/*save it in an object*/
				
				Product pd = new Product(productId,name,price,description,stockQuantity,vendorId);
				list3.add(pd);
			}
			DBUtil.dbClose();
			return list3;
	}
		@Override
		public void editProductDetails(String name1, double price1, String description1, int stockQuantity1, int vendorId1, int productId1)
				throws SQLException {
			Connection conn=DBUtil.getDBConn();
			/*List<Product> list3 = new ArrayList<>();*/
			String sql = "update product set name=?,price=?,description=?,stock_quantity=?,vendor_id=? where id =?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,name1);
			pstmt.setDouble(2, price1);
			pstmt.setString(3, description1);
			pstmt.setInt(4,stockQuantity1);
			pstmt.setInt(5, vendorId1);
			pstmt.setInt(6, productId1);
			pstmt.executeUpdate();
			DBUtil.dbClose();
			
		}
		
		@Override
		public void deleteProduct(int productId) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn=DBUtil.getDBConn();
			String sql = "delete from product where id = ?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,productId);
			pstmt.executeUpdate();
			DBUtil.dbClose();
		}


		@Override
		public void buyProductDetails(int productId) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn=DBUtil.getDBConn();
			String sql = "update product SET stock_quantity = stock_quantity - 1 WHERE id = ?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,productId);
			pstmt.executeUpdate();
			DBUtil.dbClose();
			
		}	
}
