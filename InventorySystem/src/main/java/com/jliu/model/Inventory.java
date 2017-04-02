package com.jliu.model;

public class Inventory {
	public Inventory() {
	}

	public Inventory(Product product, double price, long quantity) {
		super();
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	private long id;
	private Product product;
	private double price;
	private long quantity;
}
