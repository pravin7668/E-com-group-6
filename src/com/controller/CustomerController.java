package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.service.CustomerService;

public class CustomerController {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*****************CUSTOMER OPS ****************");
			System.out.println("Enter 1 for Inserting new customer");
			System.out.println("Enter 2 for Delete your Customer ID");
			System.out.println("Enter 0 for exit");
			System.out.println("********************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Poitu Varen da Maaplaa");
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
				try {
					customerService.insertCustomer(name,email,password);
					System.out.println("Customer inserted successfully");

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter your Customer ID ");
				int cid=sc.nextInt();
				try {
					customerService.deleteCustomer(cid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		sc.close();
	}
}