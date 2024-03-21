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
			}
		}
		sc.close();
	}
}