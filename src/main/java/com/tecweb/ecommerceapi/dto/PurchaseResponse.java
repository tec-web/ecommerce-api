package com.tecweb.ecommerceapi.dto;

import java.io.Serializable;

public class PurchaseResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String orderTrackingNumber;

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public PurchaseResponse(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}
}
