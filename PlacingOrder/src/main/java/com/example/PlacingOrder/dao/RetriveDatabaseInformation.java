package com.example.PlacingOrder.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.example.PlacingOrder.idao.RetrivingDatabseInfoInterface;
import com.example.PlacingOrder.models.Offer;
import com.example.PlacingOrder.models.Order_items;
import com.example.PlacingOrder.models.PlacingOrderModel;

/**
 * 
 * @author Ranjan Kumar
 *
 */
@Configuration
public class RetriveDatabaseInformation implements RetrivingDatabseInfoInterface {
	private static final Logger log = LoggerFactory.getLogger(RetriveDatabaseInformation.class);

	@Override
	public List<PlacingOrderModel> getAllOrders(){
		List<PlacingOrderModel> allOrders = new ArrayList<PlacingOrderModel>();
		List<Order_items> orders = new ArrayList<Order_items>();
		orders.add(new Order_items("bread",2,2200));
		orders.add(new Order_items("butter",1,5900));
		
		allOrders.add(new PlacingOrderModel(orders, 1200, new Offer("Flat", 1000)));
		return allOrders;
	}
}
