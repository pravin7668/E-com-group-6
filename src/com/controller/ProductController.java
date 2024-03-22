package com.controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.Product;
import com.service.ProductService;

public class ProductController {

	public static void main(String[] args) {
		ProductService ps = new ProductService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*****PRODUCT OPS*****");
			System.out.println("Press.1 Add a new product");
			System.out.println("Press.2 Display all products");
			System.out.println("Press.3 Sort products by price ASC/DESC");
			System.out.println("Press.4 Buy Product");
			System.out.println("Press.5 Edit Product Details");
			System.out.println("Press.6 for Deleting a product");
			System.out.println("Press.0 for exit");
			

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting thank you");
				break;
			}

			switch (input) {
			case 1:
				System.out.println("Enter your vendor id");
				int vendorId = sc.nextInt();
				System.out.println("Enter your product name:");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter your product price:");
				double price = sc.nextDouble();
				System.out.println("Enter your product description:");
				sc.nextLine();
				String description = sc.nextLine();
				System.out.println("Enter your stockQuantity:");
				int stockQuantity = sc.nextInt();

				try {
					ps.createProduct(vendorId, name, price, description, stockQuantity);
					System.out.println("Product Inserted Successfully");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 2:
				List<Product> list = new ArrayList<>();
				try {
					list = ps.displayProductDetails();
					System.out.println("************All Products************");
					for (Product pd : list) {
						System.out.println("productId" + " " + pd.getId() + "\t" + "Product Name" + " " + pd.getName()
								+ "\t" + "Product Price" + " " + pd.getPrice() + "\t" + "Stock Quantity" + " "
								+ pd.getStockQuantity());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 3:
				
				try {
					List<Product> list1 = new ArrayList<>();
					List<Product>list3 = ps.displayProductDetails();
					
					System.out.println("Product Id"+"Product Name"+"Product Price"+"Stock Quantity");
					for(Product pd:list3) {
						System.out.println(pd.getId()+" "+pd.getName()+" "+pd.getPrice()+" "+pd.getStockQuantity());
					}
					System.out.println("************************");
					System.out.println("Do you want to sort by Price");
					System.out.println("Press A for ASC order");
					System.out.println("Press D for DESC order");
					String order = sc.next();
					if(!(order.equalsIgnoreCase("A")|| order.equalsIgnoreCase("D"))) {
						System.out.println("Invalid selection");
						break;
						
					}
					System.out.println("Now sort by order "+order);
					if(order.equalsIgnoreCase("A")) {
						System.out.println("Ordered by Ascending");
						list1 = ps.displaysortProductDetails(list3,order);
					}
					
					if(order.equalsIgnoreCase("D")) {
						System.out.println("Ordered by Descending");
						list1 = ps.displaydescsortProductDetails(list3,order);
					}
						
					
					
					System.out.println("************All Products************");
					System.out.println("ProductId"+"Product Name"+"Product Price"+"Stock Quantity");
					for (Product pd:list1) {
						System.out.println(pd.getId()+"\t"+pd.getName()+"\t"+pd.getPrice()+"\t"+pd.getStockQuantity());
					}
					System.out.println("*************************************");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			
			
			}
		}
		sc.close();
	}
}