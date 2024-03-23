package com.dto;

public class CustomerOrdersDto {
private String customerName;
private String productName;
private double totalPrice;
private int quantity;
public CustomerOrdersDto() {
	super();
}
public CustomerOrdersDto(String customerName, String productName, double totalPrice, int quantity) {
	super();
	this.customerName = customerName;
	this.productName = productName;
	this.totalPrice = totalPrice;
	this.quantity = quantity;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "CustomerOrders [customerName=" + customerName + ", productName=" + productName + ", totalPrice="
			+ totalPrice + ", quantity=" + quantity + "]";
}

}
