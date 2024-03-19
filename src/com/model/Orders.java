package com.model;

import java.time.LocalDate;

public class Orders {
	private int id;
	private int customerId;
	private int productId;
	private double totalPrice;
	private String shippingAddress;
	private int quantity;
	private LocalDate orderDate;

	public Orders() {
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", customerId=" + customerId + ", productId=" + productId + ", totalPrice="
				+ totalPrice + ", shippingAddress=" + shippingAddress + ", quantity=" + quantity + ", orderDate="
				+ orderDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Orders(int id, int customerId, int productId, double totalPrice, String shippingAddress, int quantity,
			LocalDate orderDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.productId = productId;
		this.totalPrice = totalPrice;
		this.shippingAddress = shippingAddress;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}

	public Orders(int customerId, int productId, double totalPrice, String shippingAddress, int quantity,
			LocalDate orderDate) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.totalPrice = totalPrice;
		this.shippingAddress = shippingAddress;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}
}
