package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.exception.CustomerNotFoundException;
import com.exception.VendorNotFoundException;
import com.model.Customer;
import com.model.User;
import com.model.Vendor;
import com.service.AuthenticationService;

public class AuthenticationController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		AuthenticationService authenticationService = new AuthenticationService();
		while (true) {

			System.out.println();
			System.out.println("***AUHTNETICATION OPERATION***");
			System.out.println("Press 1. Sign up for Customer");
			System.out.println("Press 2. Sign up for Vendor");
			System.out.println("Press 3. Login");
			System.out.println("Press 0. Exit");
			System.out.println("**************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting....Thank you!!!");
				break;
			}
			switch (input) {
			case 1:
				System.out.println("Enter Your Name");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter your Email ");
				String email = sc.nextLine();

				while (true) {
					System.out.println("Enter your Password");
					String password = sc.nextLine();
					System.out.println("Enter Confirm Password");
					String confirmPassword = sc.nextLine();
					boolean confirmPasswordCorrect = authenticationService.checkConfirmPassword(password,
							confirmPassword);
					if (confirmPasswordCorrect) {
						System.out.println("Sign Up Completed....You Can Login :)");
						System.out.println();
						try {
							String role = "CUSTOMER";
							authenticationService.addUser(email, password, role);
							authenticationService.addCustomer(name, email, password);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					} else {
						System.out.println("Password and Confirm Password Mismatch");

					}
				}
				break;

			case 2:
				System.out.println("Enter Your Name");
				sc.nextLine();
				 name = sc.nextLine();
				System.out.println("Enter your Email ");
				email = sc.nextLine();
				System.out.println("Enter your Address ");
				String address = sc.nextLine();

				while (true) {
					System.out.println("Enter your Password");
					String password = sc.nextLine();
					System.out.println("Enter Confirm Password");
					String confirmPassword = sc.nextLine();
					boolean confirmPasswordCorrect = authenticationService.checkConfirmPassword(password,
							confirmPassword);
					if (confirmPasswordCorrect) {
						System.out.println("Sign Up Completed....You Can Login :)");
						System.out.println();
						try {
							String role = "VENDOR";
							authenticationService.addUser(email, password, role);
							authenticationService.addVendor(name, email, password,address);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					} else {
						System.out.println("Password and Confirm Password Mismatch");

					}
				}
				break;

			case 3:

				System.out.println("Enter Your Email");
				sc.nextLine();
				String cEmail = sc.nextLine();
				try {
					User user = authenticationService.validateEmail(cEmail);
					Customer customer = authenticationService.getCustomerId(cEmail);
					Vendor vendor=authenticationService.getVendorId(cEmail);;
					System.out.println("Enter Your Password");
					String userPassword = sc.nextLine();
					boolean isUserPasswordCorrect = authenticationService.validatePassword(user, userPassword);

					if (isUserPasswordCorrect) {

						if (user.getRole().equalsIgnoreCase("CUSTOMER")) {
							while (true) {
								System.out.println();
								System.out.println("***OPERATIONS FOR CUSTOMER***");
								System.out.println("Press 1 For CUSTOMER OPS");
								System.out.println("Press 2 For PRODUCT OPS");
								System.out.println("Press 3 For ORDERS OPS");
								System.out.println("Press 4 For CART OPS");
								System.out.println("Press 0 To Exit");

								System.out.println("**************");
								int input1 = sc.nextInt();
								if (input1 == 0) {
									System.out.println("Exiting....Thank you!!!");
									break;
								}
								switch (input1) {
								case 1:
									CustomerController.customerController(customer);
									break;
								case 2:
									break;
								case 3:
									break;
								case 4:
									break;
								}

							}
						}
						if(user.getRole().equalsIgnoreCase("VENDOR")) {
								VendorController.vendorController(vendor);
						}

					}
					while (!isUserPasswordCorrect) {
						System.out.println("Press 1 to Login Again");
						System.out.println("Press 2 to Reset Your Password");
						int passwordReset = sc.nextInt();
						if (passwordReset == 2) {
							System.out.println("Enter Your Email");
							sc.nextLine();
							cEmail = sc.nextLine();
							user = authenticationService.validateEmail(cEmail);
							System.out.println("Enter Your New Password");
							userPassword = sc.nextLine();
							System.out.println("Enter New Confirm Password");
							String confirmPassword = sc.nextLine();
							boolean isPasswordCorrect = authenticationService.checkConfirmPassword(userPassword,
									confirmPassword);
							if (isPasswordCorrect) {
								authenticationService.updateUserPassword(cEmail, userPassword);
								authenticationService.updatePassword(cEmail, userPassword);
								System.out.println("Password Reset Successful");

							} else {
								System.out.println("Password and Confirm Password Mismatch");
							}
						}
						if (passwordReset == 1) {
							System.out.println("Enter Your Email");
							sc.nextLine();
							cEmail = sc.nextLine();
							user = authenticationService.validateEmail(cEmail);

							System.out.println("Enter Your Password");
							userPassword = sc.nextLine();
							isUserPasswordCorrect = authenticationService.validatePassword(user, userPassword);

							if (isUserPasswordCorrect) {
								if (user.getRole().equalsIgnoreCase("CUSTOMER")) {
									CustomerController.customerController(customer);
									break;
								}

							}
						}

					}
				} catch (SQLException | CustomerNotFoundException | VendorNotFoundException e) {
					System.out.println(e.getMessage());
				}

			}
		}
	}
}
