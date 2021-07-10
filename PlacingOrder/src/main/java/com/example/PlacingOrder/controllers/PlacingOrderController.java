package com.example.PlacingOrder.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.PlacingOrder.models.PlacingOrderModel;
import com.example.PlacingOrder.service.ExceptionService;
import com.example.PlacingOrder.service.PlacingOrderService;

@RestController
public class PlacingOrderController {
	
	@Autowired
	PlacingOrderService service;

	/**
	 * To find the total cost for the order.
	 * @param order
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getOrders", method = RequestMethod.POST)
	public String placeOrder(@RequestBody String order) {
		String result = "";
		if (order == null || order.trim().isEmpty()) {
			result = "Request parameter can't be empty";
			throw new ExceptionService (result);
		} else {
			PlacingOrderModel placedOrder = null; 
			Map<String, Object> validInput = service.validateInput(order);
			if (validInput.containsKey("Success")) {
				placedOrder = (PlacingOrderModel) validInput.get("Success");
				result = service.getOrderCost(placedOrder);
			} else {
				result = (String) validInput.get("Failed");
				throw new ExceptionService (result);
			}
						
		}
		return result;
	}
	
	/**
	 * To show order example (JSON input string).
	 * @return
	 */
	@RequestMapping("/orders")
	public List<PlacingOrderModel> getOrder() {
		List<PlacingOrderModel> allOrders = service.getAllRecords();
		return allOrders;
	}

}
