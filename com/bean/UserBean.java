package com.bean;

public class UserBean {
	private int cid;
	private String name, email, password;

	public UserBean(int cid, String name, String email, String password) {
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	//getter
	public int getCid() {
		return cid;
	}

	//setter
	public void setCid(int cid) {
		this.cid = cid;
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
	
}