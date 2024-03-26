package com.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.exception.CustomerNotFoundException;
import com.model.Customer;
import com.model.User;
import com.service.AuthenticationService;

public class AuthenticationServiceTest {
	AuthenticationService authenticationService=new AuthenticationService();
/******************************************************************************************/
	@Test
	public void checkConfirmPassword() {
		//Use Case "Valid Credentials"
		String password="pravin";
		String confirmPassword="pravin";
		boolean expectedOutput=true;
		Assert.assertEquals(expectedOutput, authenticationService.checkConfirmPassword(password, confirmPassword));
		
		//Use Case "Invalid Credentials"
		password="pravin";
		confirmPassword="INVALID";
		expectedOutput=false;
		Assert.assertEquals(expectedOutput, authenticationService.checkConfirmPassword(password, confirmPassword));
	}
	
/******************************************************************************************/
	@Test
	public void validatePassword() {
		//Use Case "Valid Credentials"
		User user=new User("pravin@gmail.com","pravin","Customer");
		String password="pravin";
		boolean expectedOutput=true;
		Assert.assertEquals(expectedOutput, authenticationService.validatePassword(user, password));

		//Use Case "InValid Credentials"
		password="INVALID";
		expectedOutput=false;
		Assert.assertEquals(expectedOutput, authenticationService.validatePassword(user, password));

	}
	
/******************************************************************************************/
	@Test
	public void validateEmail() {
		//Use Case "Valid Credentials"
		String email="pravin@gmail.com";
		User expectedOutput=new User(1,"pravin@gmail.com","pravin","CUSTOMER");
		try {
			Assert.assertEquals(expectedOutput, authenticationService.validateEmail(email));
		} catch (SQLException | CustomerNotFoundException e) {		} 
		
		//Use Case "InValid Credentials"
		email="INVALID";
		try {
			Assert.assertEquals(expectedOutput, authenticationService.validateEmail(email));
		} catch (SQLException | CustomerNotFoundException e) {		
			Assert.assertEquals("User Not Found".toLowerCase(), e.getMessage().toLowerCase());

		} 

	}
/******************************************************************************************/
	@Test
	public void getCustomerId() {
		//Use Case "Valid Credentials"
		String email="pravin@gmail.com";
		Customer expectedOutput=new Customer(19,"Pravin","pravin@gmail.com","pravin");
		try {
			Assert.assertEquals(expectedOutput, authenticationService.getCustomerId(email));
		} catch (SQLException | CustomerNotFoundException e) {		}
		
		//Use Case "InValid Credentials"
		email="INVALID";
		try {
			Assert.assertEquals(expectedOutput, authenticationService.getCustomerId(email));
		} catch (SQLException | CustomerNotFoundException e) {	
			Assert.assertEquals("Customer Not Found".toLowerCase(), e.getMessage().toLowerCase());

		}

	}
/******************************************************************************************/

	
}
