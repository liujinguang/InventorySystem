package com.jliu.model;

import java.util.Date;

public class SellRecord {
	public SellRecord() {
	}

	public SellRecord(Customer customer, Product product, double price, long quantity, long discount, Date date,
			Employee operator, Employee clerk, String settlementMode, String comment) {
		super();
		this.customer = customer;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
		this.date = date;
		this.operator = operator;
		this.clerk = clerk;
		this.settlementMode = settlementMode;
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public long getDiscount() {
		return discount;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employee getOperator() {
		return operator;
	}

	public void setOperator(Employee operator) {
		this.operator = operator;
	}

	public Employee getClerk() {
		return clerk;
	}

	public void setClerk(Employee clerk) {
		this.clerk = clerk;
	}

	public String getSettlementMode() {
		return settlementMode;
	}

	public void setSettlementMode(String settlementMode) {
		this.settlementMode = settlementMode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	private long id;
	private Customer customer;
	private Product product;
	private double price;
	private long quantity;
	private long discount;
	private Date date;
	private Employee operator;
	private Employee clerk;
	private String settlementMode;
	private String comment;
}
