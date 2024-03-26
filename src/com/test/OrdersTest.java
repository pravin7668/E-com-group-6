package com.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.model.Orders;
import com.service.OrdersService;

public class OrdersTest {
	OrdersService ordersservice=new OrdersService();
	
	
	/******************************************************/
	@Test
	public void getByCustomerId() {
		//Use case "Valid Credentials"
		
		int id=1;
		LocalDate date1 = LocalDate.parse("2024-01-01");
		Orders expectedOrder=new Orders(30,1,1,300,"brooklyn",2,date1);
		try {
			Assert.assertEquals(expectedOrder, ordersservice.getOrderDetailsOfCustomer(id));
		} catch (SQLException e){		
			e.printStackTrace();
		}
		
		//Use Case "Invalid Credentials"
		
		int id1=10;
		LocalDate date2 = LocalDate.parse("2023-01-01");
		Orders invalidOrder=new Orders(30,1,1,300,"brooklyn",2,date2);
		try {
			Assert.assertEquals(invalidOrder, ordersservice.getOrderDetailsOfCustomer(id1));
		} catch (SQLException e){	
			 System.out.println("invalid id or no order in that id");
			e.printStackTrace();
			
		}
		
	}
	
	/******************************************************/
	@Test
	public void getOrderInRangeTest() {
		//Use case "Valid Credentials"
		int id=1;
		 LocalDate date1 = LocalDate.parse("2024-01-01");
	     LocalDate date2 = LocalDate.parse("2024-12-12");
	     LocalDate date3 = LocalDate.parse("2024-01-01");
	     Orders expectedValues=new Orders(30,1,1,300,"brooklyn",2,date3);
	     try {
	    	 Assert.assertEquals(expectedValues,ordersservice.getOrderInRange(id,date1,date2));
	     }
	     catch (SQLException e) {
	    	 e.printStackTrace();
	     }
	     
	   //Use Case "Invalid Credentials" 
	     LocalDate date4 = LocalDate.parse("2024-12-01");
	     LocalDate date5 = LocalDate.parse("2024-12-12");
	     LocalDate date6 = LocalDate.parse("2024-01-01");
	     Orders invalidValues=new Orders(30,1,1,300,"brooklyn",2,date6);
	     try {
	    	 Assert.assertEquals(invalidValues,ordersservice.getOrderInRange(id,date4,date5));
	     }
	     catch (SQLException e) {
	    	 System.out.println("Invalid Dates");
	    	 e.printStackTrace();
	     }
	     
	     
	}
	
}
