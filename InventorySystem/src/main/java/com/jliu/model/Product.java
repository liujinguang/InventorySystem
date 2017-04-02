package com.jliu.model;

public class Product {
	public Product() {
	}

	public Product(String name, String abbreviation, String producingArea, String vendor, String description,
			String approvalNo, String serialNo, String spec, String packaging, Supplier supplier) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.producingArea = producingArea;
		this.vendor = vendor;
		this.description = description;
		this.approvalNo = approvalNo;
		this.serialNo = serialNo;
		this.spec = spec;
		this.packaging = packaging;
		this.supplier = supplier;
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

	public String getProducingArea() {
		return producingArea;
	}

	public void setProducingArea(String producingArea) {
		this.producingArea = producingArea;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApprovalNo() {
		return approvalNo;
	}

	public void setApprovalNo(String approvalNo) {
		this.approvalNo = approvalNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	private long id;
	private String name;
	private String abbreviation;
	private String producingArea;
	private String vendor;
	private String description;
	private String approvalNo;
	private String serialNo;
	private String spec;
	private String packaging;
	private Supplier supplier;
}
