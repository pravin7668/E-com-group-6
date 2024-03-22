package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.Customer;
import com.model.Vendor;

import com.service.*;

public class VendorController {

	public static void main(String[] args) {
		VendorService vendorService = new VendorService();
		Scanner sc = new Scanner(System.in);
		List<Vendor> list = new ArrayList<Vendor>();
		while (true) {
			System.out.println("*****************CUSTOMER OPS ****************");
			System.out.println("Enter 1 for add new vendor");
			System.out.println("Enter 2 for add new Product");
			System.out.println("Enter 3 for update  Product");
			System.out.println("Enter 4 for display all products by vendor id");
			System.out.println("enter 5 for search vendor by name");
			System.out.println("enter 6 for display all vendors");
			System.out.println("********************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("thank you");
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
					vendorService.insertvendor(name,email,password,address);
					System.out.println("Vendor inserted successfully");

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter your vendor ID ");
				int vid=sc.nextInt();
				sc.nextLine();
				System.out.println("enter you name");
				String pname=sc.nextLine();
				System.out.println("enter you price");
				double price=sc.nextDouble();
				sc.nextLine();
				System.out.println("enter you description");
				String description=sc.nextLine();
				System.out.println("enter you stock quantity");
				int stock_quantity=sc.nextInt();
				
				try {
					
					vendorService.insertproduct(vid,pname,price,description,stock_quantity);
					System.out.println("Product inserted successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter your vendor ID ");
				int uid=sc.nextInt();
				sc.nextLine();
				System.out.println("enter you name");
				String vname=sc.nextLine();
				System.out.println("enter you price");
				double vprice=sc.nextDouble();
				sc.nextLine();
				System.out.println("enter you description");
				String vdescription=sc.nextLine();
				System.out.println("enter you stock quantity");
				int vstock_quantity=sc.nextInt();
				
				try {
					
					vendorService.updateproduct(uid,vname,vprice,vdescription,vstock_quantity);
					System.out.println("Product updated successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
			case 4:
				System.out.println("Enter your vendor ID ");
				vid=sc.nextInt();
				try {
					Vendor v = vendorService .displayproducts(vid);
					System.out.println(v);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				sc.nextLine();
				System.out.println("Enter your vendor Name ");
				name=sc.nextLine();
				try {
					Vendor v = vendorService.searchvendor(name);
					System.out.println(v);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				
				try {
					list=vendorService.displayallvendor();
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
		sc.close();
	}

}

