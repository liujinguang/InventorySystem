package com.jliu.model;

import java.util.Date;

public class SellReturnedRecord {
	public SellReturnedRecord() {
	}

	public SellReturnedRecord(SellRecord sellRecord, Employee operator, Employee clerk, Date date, long quantity,
			double price, String comment) {
		super();
		this.sellRecord = sellRecord;
		this.operator = operator;
		this.clerk = clerk;
		this.date = date;
		this.quantity = quantity;
		this.price = price;
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SellRecord getSellRecord() {
		return sellRecord;
	}

	public void setSellRecord(SellRecord sellRecord) {
		this.sellRecord = sellRecord;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	private long id;
	private SellRecord sellRecord;
	private Employee operator;
	private Employee clerk;
	private Date date;
	private long quantity;
	private double price;
	private String comment;
}
