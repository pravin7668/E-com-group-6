package com.test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.exception.VendorNotFoundException;
import com.model.*;
import com.service.*;
public class VendorServiceTest {

	VendorService vendorService=new VendorService();
	@Test
	public void searchVendor() throws VendorNotFoundException   {
		//Use Case " Valid Credentials"
		String name="Tech Mart";
		Vendor expectedVendor=new Vendor(1,"Tech Mart","info@techmart.com","techmartpass","Mumbai");

		try {
			Assert.assertEquals(expectedVendor, vendorService.searchVendor(name));
		} catch (SQLException e){		
			
		}
		//Use Case "Invalid Credentials"
		
		//name="INVALID";
		try {
			Assert.assertEquals(expectedVendor, vendorService.searchVendor(name));
		} catch (SQLException | VendorNotFoundException e) {
			Assert.assertEquals("Vendor Not Found Please Check The Name".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	@Test
	public void displayAllVendors()  {
		List<Vendor> expectedvendors=new ArrayList<Vendor>();
		Vendor v1=new Vendor(1,"Tech Mart","info@techmart.com","techmartpass","Mumbai");
		Vendor v2=new Vendor(2,"Fashion Plus","sales@fashionplus.com","fashionpass","Delhi");
		Vendor v3=new Vendor(3,"Home Essentials","info@homeessentials.com","homepass","Bangalore");
		Vendor v4=new Vendor(4,"Bookworm Books","info@bookwormbooks.com","bookwormpass","Kolkata");
		Vendor v5=new Vendor(5,"Garden Paradise","sales@gardenparadise.com","gardenpass","Chennai");
		Vendor v6=new Vendor(6,"Sports Galore","info@sportsgalore.com","sportspass","Hyderabad");
		Vendor v7=new Vendor(7,"Pet Palace","sales@petpalace.com","petpass","Pune");
		Vendor v8=new Vendor(8,"Music World","info@musicworld.com","musicpass","Jaipur");
		Vendor v9=new Vendor(9,"Artistic Creations","sales@artisticcreations.com","artpass","Ahmedabad");
		Vendor v10=new Vendor(10,"Foodie Heaven","info@foodieheaven.com","foodpass","Kochi");
		Vendor v11=new Vendor(11,"raja","raja@gmail.com","12345","west street");
		Vendor v12=new Vendor(12,"prasanna","prasanna@gmail.com","prasanna03","nehru street");
		
		expectedvendors.add(v1);
		expectedvendors.add(v2);
		expectedvendors.add(v3);
		expectedvendors.add(v4);
		expectedvendors.add(v5);
		expectedvendors.add(v6);
		expectedvendors.add(v7);
		expectedvendors.add(v8);
		expectedvendors.add(v9);
		expectedvendors.add(v10);
		expectedvendors.add(v11);
		expectedvendors.add(v12);
		
		
		try {
			Assert.assertEquals(expectedvendors, vendorService.displayAllVendor());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void displayProducts() throws VendorNotFoundException  {
		int id=2;
		Vendor expectedProduct=new Vendor(12,"vijay",1000.0 ,"good product",2);

		try {
			Assert.assertEquals(expectedProduct, vendorService.displayProducts(id));
		} catch (SQLException e){		
			
		}
		//Use Case "Invalid Credentials"
		
		try {
			Assert.assertEquals(expectedProduct, vendorService.displayProducts(id));
		} catch (SQLException e) {
			Assert.assertEquals("Vendor Not Found Please Check The Name".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	

	

}
