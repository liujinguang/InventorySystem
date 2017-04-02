package com.jliu.model;

public class WarehouseInRecord {
	public WarehouseInRecord() {
	}

	public WarehouseInRecord(Product product, Employee operator, Employee clerk, String settlementMode, double price,
			long quantity) {
		super();
		this.product = product;
		this.operator = operator;
		this.clerk = clerk;
		this.settlementMode = settlementMode;
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
	private Employee operator;
	private Employee clerk;
	private String settlementMode;
	private double price;
	private long quantity;

}
