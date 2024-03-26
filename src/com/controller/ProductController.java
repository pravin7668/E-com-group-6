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
					List<Product> list3 = ps.displayProductDetails();
					/*List<Product> list4 = ps.displayProductDetails();*/
					System.out.println("Product Id" + "Product Name" + "Product Price" + "Stock Quantity");
					for (Product pd : list3) {
						System.out.println(
								pd.getId() + " " + pd.getName() + " " + pd.getPrice() + " " + pd.getStockQuantity());
					}
					System.out.println("************************");
					System.out.println("Do you want to sort by Price");
					System.out.println("Press A for ASC order");
					System.out.println("Press D for DESC order");
					String order = sc.next();
					if (!(order.equalsIgnoreCase("A") || order.equalsIgnoreCase("D"))) {
						System.out.println("Invalid selection");
						break;

					}
					System.out.println("Now sort by order " + order);
					if (order.equalsIgnoreCase("A")) {
						System.out.println("Ordered by Ascending");
						list1 = ps.displaysortProductDetails(list3, order);
					}

					if (order.equalsIgnoreCase("D")) {
						System.out.println("Ordered by Descending");
						list1 = ps.displaydescsortProductDetails(list3, order);
					}

					System.out.println("************All Products************");
					System.out.println("ProductId" + "Product Name" + "Product Price" + "Stock Quantity");
					for (Product pd : list1) {
						System.out.println(
								pd.getId() + "\t" + pd.getName() + "\t" + pd.getPrice() + "\t" + pd.getStockQuantity());
					}
					System.out.println("*************************************");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
				
			case 4:
				try {
					list = ps.displayProductDetails();
					System.out.println("************All Products************");
					for (Product pd : list) {
						System.out.println("productId" + " " + pd.getId() + "\t" + "Product Name" + " " + pd.getName()
								+ "\t" + "Product Price" + " " + pd.getPrice() + "\t" + "Stock Quantity" + " "
								+ pd.getStockQuantity());
						System.out.println("Select the productId you want to buy");
						/*int id = sc.nextInt();*/
						sc.nextLine();
						/*if(pd.getStockQuantity()==0) {
							System.out.println("Stock not available");
						}*/
						int productId =sc.nextInt();
						ps.buyProductDetails(productId);
						if (productId == pd.getId()) {
							if(pd.getStockQuantity()==0) {
								System.out.println("Stock not available");
							}
							System.out.println("Product Bought Successfully");
						}

						else {
							System.out.println("Id is Incorrect");
						}

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				try {

					list = ps.displayProductDetails();
					System.out.println("************All Products************");
					for (Product pd : list) {
						System.out.println("productId" + " " + pd.getId() + "\t" + "Product Name" + " " + pd.getName()
								+ "\t" + "Product Price" + " " + pd.getPrice() + "\t" + "Stock Quantity" + " "
								+ pd.getStockQuantity());
					}
					System.out.println("Select the productId you want to Edit");
					int productId1 = sc.nextInt();

					System.out.println("Enter your updated product name:");
					sc.nextLine();
					String name1 = sc.nextLine();
					System.out.println("Enter your updated product price:");
					double price1 = sc.nextDouble();
					System.out.println("Enter your updated product description:");
					sc.nextLine();
					String description1 = sc.nextLine();
					System.out.println("Enter your updated stockQuantity:");
					int stockQuantity1 = sc.nextInt();
					System.out.println("Enter your updated VendorId");
					int vendorId1 = sc.nextInt();
					ps.editProductDetails(name1, price1, description1, stockQuantity1, vendorId1, productId1);
					System.out.println("Product Updated Successfully");
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
				
			case 6:

				/*List<Product> list6 = new ArrayList<>();*/

				try {
					list = ps.displayProductDetails();

					for (Product pd : list) {
						System.out.println("productId\t" + pd.getId() + " " + "Name\t" + pd.getName());
					}
					System.out.println("Enter product id");
					int productId = sc.nextInt();
					ps.deleteProduct(productId);

					System.out.println("Product Deleted Successfully");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sc.close();

			}
		}
	}
}
