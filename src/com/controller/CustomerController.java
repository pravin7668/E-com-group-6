package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Customer;
import com.service.CustomerService;

public class CustomerController {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*****************CUSTOMER OPS ****************");
			System.out.println("Press 1 to Edit Your Details");
			System.out.println("Press 2 to Display All Customers");
			System.out.println("Press 3 to Display Products You Have Ordered");
			System.out.println("Press 4 to Search by Customer Name");
			System.out.println("Press 5 to Delete Customer");
			System.out.println("Enter 0 for exit");
			System.out.println("********************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Poitu Varen da Maaplaa");
				break;
			}

			switch (input) {

			case 1:
				System.out.println("Enter your Customer ID");
				int cid1 = sc.nextInt();

				System.out.println("Press 1 to update Name");
				System.out.println("Press 2 to update Email");
				System.out.println("Press 3 to update Password");
				int input1 = sc.nextInt();
				switch (input1) {

				case 1:
					System.out.println("Enter Name to update");
					sc.nextLine();
					String name = sc.nextLine();
					try {

						customerService.updateName(cid1, name);
						System.out.println("update Succesfull");
					} catch (SQLException e) {
						e.printStackTrace();
					}

					break;
				case 2:
					System.out.println("Enter Email to update");
					sc.nextLine();
					String email = sc.nextLine();
					try {

						customerService.updateEmail(cid1, email);
						System.out.println("update Succesfull");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;

				case 3:
					System.out.println("Enter New Password ");
					sc.nextLine();
					String password = sc.nextLine();
					try {

						customerService.updatePassword(cid1, password);
						System.out.println("update Succesfull");
					} catch (SQLException e) {
						e.printStackTrace();
					}

					break;
				}
				break;

			case 2:
				System.out.println("Displaying All Customers");
				try {
					List<Customer> list = customerService.getAllCustomer();
					for (Customer c : list) {
						System.out.println(c.getId() + "  " + c.getName() + "  " + c.getEmail());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		sc.close();
	}
}
