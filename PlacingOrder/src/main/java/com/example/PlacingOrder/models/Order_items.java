package com.example.PlacingOrder.models;

/**
 * 
 * @author Ranjan Kumar
 *
 */
public class Order_items {
	String name = null;
	int quantity;
	int price;
	
	public Order_items(String name, int quantity, int price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	

}
