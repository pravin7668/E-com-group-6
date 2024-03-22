package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.Cart;
import com.service.CartService;

public class CartController {

	public static void main(String[] args) {
	CartService cs = new CartService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*****Cart OPS*****");
			System.out.println("Press.1 Add products to cart");
			System.out.println("Press.2 Display all products of cart");
			System.out.println("Press.2 update quantity of products of cart");
			


			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting thank you");
				break;
			}

			switch (input) {
			case 1:
				System.out.println("Enter your id");
				int id = sc.nextInt();
				System.out.println("Enter your customer id:");
				int customerId = sc.nextInt();
				System.out.println("Enter your product id:");
				int productId = sc.nextInt();
				System.out.println("Enter your Quantiy:");
				int quantity = sc.nextInt();
				

				try {
					
					cs.addProduct(id, customerId, productId, quantity );
					System.out.println("Product Inserted Successfully into cart");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				List<Cart> list = new ArrayList<>();
				try {
					
					list = cs.displayCartDetails();
					System.out.println("************All Products************");

					for (Cart cd : list) {
						System.out.println("id" + " " + cd.getId() + "\t" + "Customer Id" + " " + cd.getCustomerId()
								+ "\t" + "Product ID" + " " + cd.getProductId() + "\t" + "Quantity" + " "
								+ cd.getQuantity());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		sc.close();
	}
	
}
