package com.jliu.model;

public class Employee {
	public Employee() {
	}

	public Employee(String name, String telephone, String address) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private long id;
	private String name;
	private String telephone;
	private String address;
}
