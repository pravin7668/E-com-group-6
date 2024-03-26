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
		String name="prasanna";
		Vendor expectedVendor=new Vendor(12,"prasanna","prasanna@gmail.com","prasanna03","nehru street");

		try {
			Assert.assertEquals(expectedVendor, vendorService.searchVendor(name));
		} catch (SQLException e){		
			
		}
		//Use Case "Invalid Credentials"
		
		name="INVALID";
		try {
			Assert.assertEquals(expectedVendor, vendorService.searchVendor(name));
		} catch (SQLException | VendorNotFoundException e) {
			Assert.assertEquals("Vendor Not Found Please Check The Name".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	

}
