package com.jliu.model;

public class User {
	public User() {
	}

	public User(String name, String loginName, String password, String authority) {
		super();
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.authority = authority;
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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	private long id;
	private String name;
	private String loginName;
	private String password;
	private String authority;
}
