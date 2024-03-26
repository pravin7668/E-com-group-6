package com.dto;

import java.util.Objects;

public class CustomerOrdersDto {
@Override
	public int hashCode() {
		return Objects.hash(customerName, productName, quantity, totalPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerOrdersDto other = (CustomerOrdersDto) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(productName, other.productName)
				&& quantity == other.quantity
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}
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
