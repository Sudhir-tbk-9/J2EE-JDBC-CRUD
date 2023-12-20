package com.jsp.jdbc_with_CallableStatement.dto;

public class LaptopDto {
	
	private int id ;
	private String name ;
	private String color;
	private double price ;
	
	
	public LaptopDto(int id, String name, String color, double price) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Laptop with id : " + id + " of brand " + name + " in " + color + " color , available at ₹ " + price + " only. ";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
