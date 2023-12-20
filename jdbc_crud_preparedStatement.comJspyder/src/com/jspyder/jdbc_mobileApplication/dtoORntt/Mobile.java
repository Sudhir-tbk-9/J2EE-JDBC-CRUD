package com.jspyder.jdbc_mobileApplication.dtoORntt;

import java.time.LocalDate;

public class Mobile {

	private int id ;
	private String name ;
	private String color ; 
	private double price ;
	LocalDate purchaseDate ;
	
	public Mobile() {
		super();
	}
	
	
	public Mobile(int id, String name, String color, double price, LocalDate purchaseDate) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.purchaseDate = purchaseDate;
	
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
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	@Override
	public String toString() {
		return "Mobile with id : " + id + " of brand  " + name + " in " + color +" \ncolor " + " at price of " + price + " Rupees was purchase on "
				+ purchaseDate ;
	}
	

}
//====================================================
