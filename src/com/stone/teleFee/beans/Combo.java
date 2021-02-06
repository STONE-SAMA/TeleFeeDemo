package com.stone.teleFee.beans;

public class Combo {//套餐信息
	private Integer id;//套餐id
	private String name;//套餐名
	private double price;//套餐价格
	private String description;//套餐描述
	private String img;//套餐图片
	
	public Combo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Combo(Integer id, String name, double price, String description, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.img = img;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Combo [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", img="
				+ img + "]";
	}

	
	

}
