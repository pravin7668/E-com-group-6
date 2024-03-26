package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dto.CustomerOrdersDto;
import com.exception.CustomerNotFoundException;
import com.model.Customer;
import com.service.CustomerService;
public class CustomerServiceTest {
	CustomerService customerService=new CustomerService();

/**********************************************************************************/

	@Test
	public void validateToDeleteTest() {
		//Use case "Valid Credentials"
		
		String forDelete="CONFIRM";
		boolean expectedOutput=true;
		Assert.assertEquals(expectedOutput, customerService.validateToDelete(forDelete));
		//Use case "Invalid Credentials"
		
		forDelete="INVALID";
		expectedOutput=false;
		Assert.assertEquals(expectedOutput, customerService.validateToDelete(forDelete));
	}
	
/**********************************************************************************/
	@Test
	public void getCustomerOrdersTest()  {
		int id=1;
		List<CustomerOrdersDto> expectedCustomerOrders=new ArrayList<CustomerOrdersDto>();
		CustomerOrdersDto o1=new CustomerOrdersDto("sachin","Ball",4000,10);
		expectedCustomerOrders.add(o1);
		try {
			Assert.assertEquals(expectedCustomerOrders,customerService.getCustomerOrders(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
/**********************************************************************************/

	@Test
	public void searchCustomer()  {
		//Use Case " Valid Credentials"
		String name="Pravin";
		Customer expectedCustomer=new Customer(19,"Pravin","pravin@gmail.com",null);

		try {
			Assert.assertEquals(expectedCustomer, customerService.searchCustomer(name));
		} catch (SQLException | CustomerNotFoundException e) {		}
		//Use Case "Invalid Credentials"
		
		name="INVALID";
		try {
			Assert.assertEquals(expectedCustomer, customerService.searchCustomer(name));
		} catch (SQLException | CustomerNotFoundException e) {
			Assert.assertEquals("Customer Not Found Please Check The Name".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
	
/**********************************************************************************/

	@Test
	public void getAllCustomers()  {
		List<Customer> expectedCustomers=new ArrayList<Customer>();
		Customer c1=new Customer(1,"sachin","sachin@gmail.com",null);
		Customer c2=new Customer(2,"Virat Kohli","virat@gmail.com",null);
		Customer c3=new Customer(3,"Rohit Sharma","rohit@gmail.com",null);
		Customer c4=new Customer(4,"MS Dhoni","dhoni@gmail.com",null);
		Customer c5=new Customer(5,"Jasprit Bumrah","jasprit@gmail.com",null);
		Customer c6=new Customer(6,"Ravindra Jadeja","jadeja@gmail.com",null);
		Customer c7=new Customer(7,"Ajinkya Rahane","ajinkya@gmail.com",null);
		Customer c8=new Customer(8,"KL Rahul","kl@gmail.com",null);
		Customer c9=new Customer(9,"Hardik Pandya","hardik@gmail.com",null);
		Customer c10=new Customer(10,"Yuzvendra Chahal","chahal@gmail.com",null);
		Customer c11=new Customer(11,"Yashasvi Jaiswal","jaiswal@gmail.com",null);
		Customer c12=new Customer(12,"Shubman Gill","gill@gmail.com",null);
		Customer c13=new Customer(13,"Sarfraz Khan","sf@gmail.com",null);
		Customer c14=new Customer(19,"Pravin","pravin@gmail.com",null);
		expectedCustomers.add(c1);
		expectedCustomers.add(c2);
		expectedCustomers.add(c3);
		expectedCustomers.add(c4);
		expectedCustomers.add(c5);
		expectedCustomers.add(c6);
		expectedCustomers.add(c7);
		expectedCustomers.add(c8);
		expectedCustomers.add(c9);
		expectedCustomers.add(c10);
		expectedCustomers.add(c11);
		expectedCustomers.add(c12);
		expectedCustomers.add(c13);
		expectedCustomers.add(c14);
		
		try {
			Assert.assertEquals(expectedCustomers, customerService.getAllCustomer());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

