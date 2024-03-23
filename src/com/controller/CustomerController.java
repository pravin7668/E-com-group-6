package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.CustomerOrdersDto;
import com.exception.CustomerNotFoundException;
import com.model.Customer;
import com.service.CustomerService;

public class CustomerController {
	public static void customerController(Customer customer) {

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
				System.out.println("Thank You !!!");
				break;
			}

			switch (input) {

			case 1:

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

						customerService.updateName(customer.getId(), name);
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

						customerService.updateEmail(customer.getId(), email);
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

						customerService.updatePassword(customer.getId(), password);
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
				break;

			case 3:
				System.out.println("Displaying Products You Have Ordered");
				List<CustomerOrdersDto> list = new ArrayList<CustomerOrdersDto>();

				try {
					list = customerService.getCustomerOrders(customer.getId());
				} catch (SQLException e) {
					e.printStackTrace();
				}

				for (CustomerOrdersDto c : list) {
					System.out.println(c);
				}

				break;

			case 4:
				System.out.println("Enter Customer Name to Search");
				sc.nextLine();
				String name = sc.nextLine();
			
				try {
					Customer c = customerService.searchCustomer(name);
					System.out.println(c);
					
				} catch (SQLException | CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:

				try {
					System.out.println("Enter CONFIRM to Delete Your Customer Account");
					sc.nextLine();
					String forDelete=sc.nextLine();
					boolean toDelete=customerService.validateToDelete(forDelete);
					if (toDelete) {
						customerService.deleteOrders(customer.getId());
						customerService.deleteCart(customer.getId());
						customerService.deleteUser(customer.getEmail());
						customerService.deleteCustomer(customer.getId());
						System.out.println("Customer Deleted Succesfully");
						input=0;
					}else {
						System.out.println("Customer Not Deleted You Can Perform CUSTOMER OPS");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;
			}
			if (input == 0) {
				
				break;
			}
		}

	}

}
