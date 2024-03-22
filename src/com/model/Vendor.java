package com.model;

public class Vendor {
	private int id;
	private String name;
	private String name2;
	private double price;
	private String email;
	private String password;
	private String description;
	private String address;
	private int stock_quantity;
	public Vendor() {
		super();
	}
	public Vendor(String name, String email, String password, String address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	public Vendor(int id, String name, String email, String password, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	public Vendor(int id2, String name2, double price, String description, int stock_quantity) {
		super();
		this.id = id;
		this.name2= name2;
		this.price = price;
		this.description =description ;
		this.stock_quantity=stock_quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", name2=" + name2 + ", price=" + price + ", email=" + email
				+ ", password=" + password + ", description=" + description + ", address=" + address
				+ ", stock_quantity=" + stock_quantity + "]";
	}

}
