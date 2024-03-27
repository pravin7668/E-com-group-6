package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidIdException;
import com.model.Customer;
import com.model.Orders;
import com.model.Product;
import com.service.OrdersService;
import com.service.ProductService;

public class OrdersController {
	public static void ordersController(Customer customer) throws SQLException  {
		ProductService ps = new ProductService();
		OrdersService ordersService = new OrdersService();

		Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("********* ORDERS OPS ***********");
				System.out.println("Press 1 to Get Orders by Customer Id");
				System.out.println("Press 2 to Order items");
				System.out.println("Press 3 to Get Orders by Product Id");
				System.out.println("Press 4 to Update Order Address");
				System.out.println("Press 5 to Display Orders by date range");
				System.out.println("Press 0 to Exit");
				System.out.println("********************************************");
				int input1 = sc.nextInt();
				if (input1 == 0) {
					System.out.println("Terminated");
					break;
				}
				switch(input1) {
				case 1://ORDERS BY CUSTOMER ID
					List<Orders> list = new ArrayList<Orders>();
					try {
						list = ordersService.getOrderDetailsOfCustomer(customer.getId());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (Orders od : list) {
						System.out.println(od.getId() +" " + od.getCustomerId()+ " " + od.getProductId() +" " + od.getShippingAddress()+" " + od.getQuantity()+" " + od.getProductId() +" " + od.getOrderDate() + " "
								+ od.getQuantity());
					}
					break;
					
				case 2://ORDER ITEMS
				try {
					Customer c = ordersService.validateCustomer(customer.getId());
					
					List<Product> list2 = ps.displayProductDetails();

					for (Product e : list2) {
						System.out.println(e.getId() + "   " + e.getName()+"   "+e.getDescription()+"    "+"Available stock   "+e.getStockQuantity()+"Price/product"+"   "+e.getPrice());
					}
					System.out.println("Give the Id of the Product you want to Buy ");
					int productId = sc.nextInt();
					System.out.println("Enter number of Product you want to Buy  ");
					int numOfItems = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Address:  ");
					String address = sc.nextLine();
					boolean productAvailable=ordersService.checkIfProductAvailable(list2,numOfItems,productId);
					if(!productAvailable) {
						System.out.println("Product Unavailable");
						break;
					}
					ordersService.insertOrder(productId,customer.getId(),numOfItems,address,list2);
					System.out.println("Ordered Successfully");
					ordersService.updateAvailableProduct(list2,productId,numOfItems);
				}
				catch (SQLException | InvalidIdException e) {
					System.out.println(e.getMessage());
					
				}
				break;
				
				case 3:// ORDERS BY PRODUCT ID
					System.out.println("Enter Product ID ");
					int pid = sc.nextInt();
					List<Orders> list1 = new ArrayList<>();
					try {
					list1 = ordersService.getOrderDetailsByPID(pid);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					for (Orders od : list1) {
						System.out.println(od.getId() + " " + od.getCustomerId() + " " + od.getTotalPrice() + " "
								+ od.getQuantity());
					}
					break;
					
				case 4://UPDATE ORDER
					System.out.println("Enter New Shipping Address ");
					sc.nextLine();
					String address = sc.nextLine();
					        try {
					        	ordersService.updateAddress(customer.getId(),address);
					            System.out.println("Shipping Address Updated Successfully");
					        } catch (SQLException e) {
					            e.printStackTrace();
					        }
					 break;	
					  
					
				case 5:// ORDERS FROM DATE RANGE
					sc.nextLine();
					System.out.println("Enter a Start date in YYYY-MM-DD format: ");
				    String startDate = sc.nextLine();
				    System.out.println("Enter a End date in YYYY-MM-DD format: ");
				    String endDate = sc.nextLine();

				      LocalDate date1 = LocalDate.parse(startDate);
				      LocalDate date2 = LocalDate.parse(endDate);
					List<Orders> list3=new ArrayList<Orders>();
					list3 = ordersService.getOrderInRange(customer.getId(),date1,date2);
					System.out.println("ID    Customer ID    TotalPrice    Quantity");
					for (Orders od : list3) {
						System.out.println(od.getId() + " " + od.getCustomerId() + " " + od.getTotalPrice() + " "
								+ od.getQuantity());
					}
					break;
					
					
					
				
				
			}
		}
		sc.close();
		
	}
}
	


