package com.example.PlacingOrder.models;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Constants {
	public static final String INVALID_JSON_STRING = "Invalid Input!! Provide Input is not a JSON String.";
	public static final String INVALID_DISTANCE = "Invalid Input!! Please provide valid 'Distance' for the order.";
	public static final String INTERNAL_SERVER_ISSUE = "Inernal Server Issue";
	public static final String INVALID_QUANTITY = "Inernal Input!! Please provide valid item 'Quantity'.";
	public static final String INVALID_NAME = "Inernal Input!! Please provide valid item 'Name'";
	public static final String INVALID_PRICE = "Inernal Input!! Please provide valid item 'Price'";
	public static final String INVALID_OFFER_TYPE = "Inernal Input!! Please provide valid item 'Offer Type'";
	public static final String INVALID_OFFER_VALUE = "Inernal Input!! Please provide valid item 'Offer Value'";
	public static final String COST_OUTPUT_STRING = "{'order_total':%s}";
	
	public static final List<Integer> _price = new ArrayList<Integer>() {
		{
			add(5000);
			add(2000);
			add(1000);
			add(0);
		}
	};

	public static final List<Integer> _distance = new ArrayList<Integer>() {
		{
			add(1000);
			add(500);
			add(100);
			add(50);
		}
	};

}
