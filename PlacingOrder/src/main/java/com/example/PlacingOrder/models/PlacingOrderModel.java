package com.example.PlacingOrder.models;

import java.util.List;

/**
 * 
 * @author Ranjan Kumar
 *
 */
public class PlacingOrderModel {
	List<Order_items> order_items;
	int distance;
	Offer offer;

	public PlacingOrderModel(List<Order_items> Order_items, int distance, Offer offer){
		this.order_items = Order_items;
		this.distance = distance;
		this.offer = offer;
	}
	
	public List<Order_items> getOrder_items() {
		return order_items;
	}

	public void setOrder_items(List<Order_items> order_items) {
		this.order_items = order_items;
	}

	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public Offer getOffer() {
		return offer;
	}
	
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
}
