package com.stone.teleFee.beans;

public class User {//用户信息
	private Integer id;//业务无关主键，自增长
	private String name;//用户名
	private String phone;//用户电话
	private String password;//用户密码
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", password=" + password + "]";
	}

	
	
	
}
