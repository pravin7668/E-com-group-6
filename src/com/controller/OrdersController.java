//package com.controller;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import com.model.Orders;
//import com.service.OrdersService;
//
//public class OrdersController {
//	public static void main(String[] args) {
//		OrdersService ordersService = new OrdersService();
//
//		Scanner sc = new Scanner(System.in);
//
//		while (true) {
//			System.out.println("********* ORDERS OPS ***********");
//			System.out.println("Press 1 to Get Orders by Customer Id");
//			System.out.println("Press 0 to Exit");
//			System.out.println("**********************************");
//			int input = sc.nextInt();
//			if (input == 0) {
//				break;
//			}
//			switch (input) {
//			case 1:
//				System.out.println("Enter your Customer ID ");
//				int cid = sc.nextInt();
//				List<Orders> list = new ArrayList<Orders>();
//				try {
//					list = ordersService.getOrderDetailsOfCustomer(cid);
//					for (Orders od : list) {
//						System.out.println(od.getOrderId() + " " + od.getProductName() + " " + od.getTotalAmount() + " "
//								+ od.getQuantity());
//					}
//
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//				}
//
//				break;
//			}
//		}
//	}
//}
