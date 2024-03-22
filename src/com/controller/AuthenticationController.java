package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.exception.CustomerNotFoundException;
import com.model.Customer;
import com.service.AuthenticationService;

public class AuthenticationController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		AuthenticationService authenticationService = new AuthenticationService();
		while (true) {

			System.out.println();
			System.out.println("***AUHTNETICATION OPERATION***");
			System.out.println("press 1. Sign up for Customer");
			System.out.println("press 2. Sign up for Vendor");
			System.out.println("press 3. Login");
			System.out.println("press 0. Exit");
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
					boolean passwordCorrect = authenticationService.checkConfirmPassword(password, confirmPassword);
					if (passwordCorrect) {
						System.out.println("Sign Up Completed....You Can Login :)");
						try {
							authenticationService.addCustomer(name, email, password);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					} else {
						System.out.println("Password and Confirm Password Mismatch");

					}
				}

			case 3:
				System.out.println("Press 1 for Customer Login");
				System.out.println("Press 2 for Vendor Login");
				int login = sc.nextInt();
				if (login == 1) {
					System.out.println("Enter Your Email");
					sc.nextLine();
					String cEmail = sc.nextLine();
					try {
						Customer c = authenticationService.validateEmail(cEmail);

						System.out.println("Enter Your Password");
						String cPassword = sc.nextLine();
						boolean passwordCorrect = authenticationService.validatePassword(c, cPassword);

						if (passwordCorrect) {
							CustomerController.customerController(c.getId());
							break;

						}
						while (!passwordCorrect) {
							System.out.println("Press 1 to Login Again");
							System.out.println("Press 2 to Reset Your Password");
							int passwordReset = sc.nextInt();
							if (passwordReset == 2) {
								System.out.println("Enter Your Email");
								sc.nextLine();
								cEmail = sc.nextLine();
								c = authenticationService.validateEmail(cEmail);
								System.out.println("Enter Your New Password");
								cPassword = sc.nextLine();
								System.out.println("Enter New Confirm Password");
								String confirmPassword = sc.nextLine();
								boolean passwordCorrect1 = authenticationService.checkConfirmPassword(cPassword,
										confirmPassword);
								if (passwordCorrect1) {
									authenticationService.updatePassword(cEmail, cPassword);
									System.out.println("Password Reset Successful");

								} else {
									System.out.println("Password and Confirm Password Mismatch");
								}
							}
							if (passwordReset == 1) {
								System.out.println("Enter Your Email");
								sc.nextLine();
								cEmail = sc.nextLine();
								c = authenticationService.validateEmail(cEmail);

								System.out.println("Enter Your Password");
								cPassword = sc.nextLine();
								passwordCorrect = authenticationService.validatePassword(c, cPassword);

								if (passwordCorrect) {
									CustomerController.customerController(c.getId());
									break;
								}

							}
						}

					} catch (SQLException | CustomerNotFoundException e) {
						System.out.println(e.getMessage());
					}

				}
			}
		}
	}
}
