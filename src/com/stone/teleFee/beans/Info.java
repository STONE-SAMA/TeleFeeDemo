package com.stone.teleFee.beans;

public class Info {//用户信息
	private Integer no;//编号，业务无关主键
	private Integer user_id;//用户id
	private String phone;//用户电话
	private double money;//用户账户金额
	private Integer combo_id;//用户当前套餐id
	
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Info(Integer user_id, String phone, double money, Integer combo_id) {
		super();
		this.user_id = user_id;
		this.phone = phone;
		this.money = money;
		this.combo_id = combo_id;
	}
	
	
	public Info(double money, Integer combo_id) {
		super();
		this.money = money;
		this.combo_id = combo_id;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Integer getCombo_id() {
		return combo_id;
	}

	public void setCombo_id(Integer combo_id) {
		this.combo_id = combo_id;
	}

	@Override
	public String toString() {
		return "Info [no=" + no + ", user_id=" + user_id + ", phone=" + phone + ", money=" + money + ", combo_id="
				+ combo_id + "]";
	}
	
	
}
