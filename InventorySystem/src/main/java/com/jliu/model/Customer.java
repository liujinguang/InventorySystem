package com.jliu.model;

public class Customer {
	public Customer() {
	}

	public Customer(String name, String abbreviation, String address, String telephone, String email, String zipcode,
			String accountNo, String bankName, String fax, String contacter, String contacterPhone) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.zipcode = zipcode;
		this.accountNo = accountNo;
		this.bankName = bankName;
		this.fax = fax;
		this.contacter = contacter;
		this.contacterPhone = contacterPhone;
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

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContacter() {
		return contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
	}

	public String getContacterPhone() {
		return contacterPhone;
	}

	public void setContacterPhone(String contacterPhone) {
		this.contacterPhone = contacterPhone;
	}

	private long id;
	private String name;
	private String abbreviation;
	private String address;
	private String telephone;
	private String email;
	private String zipcode;
	private String accountNo;
	private String bankName;
	private String fax;
	private String contacter;
	private String contacterPhone;
}
