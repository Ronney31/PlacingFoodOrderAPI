package com.example.PlacingOrder.models;

/**
 * 
 * @author Ranjan Kumar
 *
 */
public class Offer {
	String offer_type = null;
	int offer_val;
	
	public Offer(String offer_type, int offer_val) {
		this.offer_type = offer_type;
		this.offer_val = offer_val;
	}
	
	public String getOffer_type() {
		return offer_type;
	}
	
	public void setOffer_type(String offer_type) {
		this.offer_type = offer_type;
	}
	
	public int getOffer_val() {
		return offer_val;
	}
	
	public void setOfferValue(int offer_val) {
		this.offer_val = offer_val;
	}
}
