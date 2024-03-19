package com.model;

public class Cart {
	private int id;
	private int customerId;
	private int productId;
	private int quantity;

	public Cart() {
		super();
	}

	public Cart(int customerId, int productId, int quantity) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Cart(int id, int customerId, int productId, int quantity) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", customerId=" + customerId + ", productId=" + productId + ", quantity=" + quantity
				+ "]";
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
