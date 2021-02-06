package com.stone.teleFee.beans;

public class records {//消费记录
	private Integer no;//编号，业务无关主键
	private String phone;//用户电话
	private double money;//消费金额
	private String time;//消费时间，yyyy-mm-dd
	private String note;//消费说明
	
	public records() {
		super();
		// TODO Auto-generated constructor stub
	}

	public records(String phone, double money, String time, String note) {
		super();
		this.phone = phone;
		this.money = money;
		this.time = time;
		this.note = note;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	

}
