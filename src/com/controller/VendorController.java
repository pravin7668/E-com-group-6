package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.Customer;
import com.model.Vendor;

import com.service.*;

public class VendorController {

	public static void vendorController() {
		VendorService vendorService = new VendorService();
		Scanner sc = new Scanner(System.in);
		List<Vendor> list = new ArrayList<Vendor>();
		while (true) {
			System.out.println("*****************VENDOR OPS ****************");
			System.out.println("Press 1 for Add New Vendor");
			System.out.println("Press 2 for Add New Product");
			System.out.println("Press 3 for Update  Product");
			System.out.println("Press 4 for Display All products by Vendor Id");
			System.out.println("Press 5 for Search Vendor by Name");
			System.out.println("Press 6 for Display All Vendors");
			System.out.println("Press 0 to Exit");
			
			System.out.println("********************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Thank You");
				break;
			}

			switch (input) {
			case 1:
				System.out.println("Enter Your Name ");
				sc.nextLine();
				String name=sc.nextLine();
				System.out.println("Enter Your Email ");
				String email=sc.nextLine();
				System.out.println("Enter Your Password ");
				String password=sc.nextLine();
				System.out.println("Enter Your Address ");
				String address=sc.nextLine();
				try {
					vendorService.insertVendor(name,email,password,address);
					System.out.println("Vendor Inserted Successfully");

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter Your Vendor ID ");
				int vid=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Your Name");
				String pname=sc.nextLine();
				System.out.println("Enter Your Price");
				double price=sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter Your Description");
				String description=sc.nextLine();
				System.out.println("Enter Your Stock Quantity");
				int stock_quantity=sc.nextInt();
				
				try {
					
					vendorService.insertProduct(vid,pname,price,description,stock_quantity);
					System.out.println("Product Inserted Successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter Your Vendor ID ");
				int uid=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Your Name");
				String vname=sc.nextLine();
				System.out.println("Enter Your Price");
				double vprice=sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter Your Description");
				String vdescription=sc.nextLine();
				System.out.println("Enter Your Stock Quantity");
				int vstock_quantity=sc.nextInt();
				
				try {
					
					vendorService.updateProduct(uid,vname,vprice,vdescription,vstock_quantity);
					System.out.println("Product Updated Successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
			case 4:
				System.out.println("Enter Your Vendor ID ");
				vid=sc.nextInt();
				try {
					Vendor v = vendorService .displayProducts(vid);
					System.out.println(v);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				sc.nextLine();
				System.out.println("Enter Your Vendor Name ");
				name=sc.nextLine();
				try {
					Vendor v = vendorService.searchVendor(name);
					System.out.println(v);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				
				try {
					list=vendorService.displayAllVendor();
					for(Vendor c:list) {
						System.out.println(c);
					}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				break;
				
			}
		}
		
	}

}

