package com.example.PlacingOrder.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PlacingOrder.dao.RetriveDatabaseInformation;
import com.example.PlacingOrder.models.Constants;
import com.example.PlacingOrder.models.Offer;
import com.example.PlacingOrder.models.Order_items;
import com.example.PlacingOrder.models.PlacingOrderModel;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * 
 * @author Ranjan Kumar
 *
 */
@Service
public class PlacingOrderService {
	private static final Logger log = LoggerFactory.getLogger(PlacingOrderService.class);

	@Autowired
	RetriveDatabaseInformation repository;
	
	Gson gson = new Gson();

	/**
	 * Method to get the example of input JSON string.
	 * @return
	 */
	public List<PlacingOrderModel> getAllRecords() {
		return repository.getAllOrders();
	}

	/**
	 * 
	 * @param PlacingOrderModel placedOrder
	 * @return
	 */
	public String getOrderCost(PlacingOrderModel placedOrder) {
		try {
			int itemTotal = getCalulation(placedOrder);
			return String.format(Constants.COST_OUTPUT_STRING, itemTotal);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			return "Provided input is not requered input(JSON) type";
		}
	}

	/**
	 * Method to Calculate the Price with applying offer if exists.
	 * 
	 * @param PlacingOrderModel placedOrder
	 * @return
	 */
	public int getCalulation(PlacingOrderModel placedOrder) {
		int result = 0;
		List<Order_items> orders = placedOrder.getOrder_items();
		Offer offer = placedOrder.getOffer();
		int distance = placedOrder.getDistance();
		int item_total = 0;
		int deliveryFee = 0;
		String offerType = offer != null && offer.getOffer_type() != null ? offer.getOffer_type() : "";
		
		for (Order_items odr : orders) {
			item_total += odr.getPrice() * odr.getQuantity();
		}

		log.info("item_total Cost: " + item_total);

		if (!offerType.equalsIgnoreCase("DELIVERY")) {
			for (int i = 0; i < Constants._distance.size(); i++) {
				if (distance > Constants._distance.get(i)) {
					deliveryFee = Constants._price.get(i);
					break;
				}
			}
		}
		
		log.info("deliveryFee Cost: " + deliveryFee);

		result = item_total + deliveryFee;

		log.info("result Cost: " + result);
		// calculation base on offer Applied
		if (!offerType.isEmpty() && !offerType.equalsIgnoreCase("DELIVERY")) {
			log.info("min : " + Math.min(offer.getOffer_val(), result));
			result = result - Math.min(offer.getOffer_val(), result);
		}
		log.info("Final Cost: " + result);
		return result;
	}

	/**
	 * Method to Validate the JSON Input w.r.t to the desired input.
	 * 
	 * @param String order
	 * @return
	 */
	public Map<String, Object> validateInput(String order) {
		PlacingOrderModel placedOrder = null;
		Map<String, Object> validInput = new HashMap<String, Object>();
		Set<String> status = new HashSet<String>();
		try {
			placedOrder = getParsedOrder(order);
			if (placedOrder.getDistance() < 0 || placedOrder.getDistance() > 500000) {
				log.error(Constants.INVALID_DISTANCE);
				status.add(Constants.INVALID_DISTANCE);
			}

			if (placedOrder.getOrder_items() != null) {
				for (Order_items ord : placedOrder.getOrder_items()) {
					if (ord.getName() != null && !ord.getName().isEmpty()) {
					} else {
						log.error(Constants.INVALID_NAME);
						status.add(Constants.INVALID_NAME);
					}
					if (ord.getQuantity() < 1) {
						log.error(Constants.INVALID_QUANTITY);
						status.add(Constants.INVALID_QUANTITY);
					}
					if (ord.getPrice() < 1) {
						log.error(Constants.INVALID_PRICE);
						status.add(Constants.INVALID_PRICE);
					}
				}
			}

			if (placedOrder.getOffer() != null && placedOrder.getOffer().getOffer_type() != null
					&& placedOrder.getOffer().getOffer_type().isEmpty()) {
				log.error(Constants.INVALID_OFFER_TYPE);
				status.add(Constants.INVALID_OFFER_TYPE);
			}

			if (placedOrder.getOffer() != null && placedOrder.getOffer().getOffer_val() < 0) {
				log.error(Constants.INVALID_OFFER_VALUE);
				status.add(Constants.INVALID_OFFER_VALUE);
			}

		} catch (JsonSyntaxException ex) {
			status.add(Constants.INVALID_JSON_STRING);
			ex.printStackTrace();
			log.error(Constants.INVALID_JSON_STRING);
		} catch (Exception ex) {
			status.add(Constants.INTERNAL_SERVER_ISSUE);
			ex.printStackTrace();
			log.error("Unknown Error", ex);
		}

		if (status != null && !status.isEmpty()) {
			validInput.put("Failed", setToSting(status));
		} else {
			validInput.put("Success", placedOrder);
		}

		return validInput;
	}

	/**
	 * Method to Parse the input JSON String to PlacingOrderModel class objec.
	 * 
	 * @param String order
	 * @return
	 * @throws Exception
	 */
	private PlacingOrderModel getParsedOrder(String order) throws Exception {
		PlacingOrderModel res = gson.fromJson(order, PlacingOrderModel.class);
		return res;
	}

	/**
	 * Method to convert List<PlacingOrderModel> to String.
	 * 
	 * @param List<PlacingOrderModel> orders
	 * @return
	 */
	public String toJson(List<PlacingOrderModel> orders) {
		try {
			return gson.toJson(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Caught Exception with toJson()";
	}

	/**
	 * Method to convert Set<String> to ,\n separate String.
	 * 
	 * @param Set<String> stringSet
	 * @return
	 */
	private String setToSting(Set<String> stringSet) {
		return String.join(",\n ", stringSet);
	}

}
