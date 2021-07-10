package com.example.PlacingOrder.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Ranjan Kumar
 *
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ExceptionService extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionService(String exceptionMessage) {
		super(exceptionMessage);
		
	}
}
